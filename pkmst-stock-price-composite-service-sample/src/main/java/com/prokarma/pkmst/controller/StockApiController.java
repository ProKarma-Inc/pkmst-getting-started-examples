package com.prokarma.pkmst.controller;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import com.google.common.collect.Maps;
import com.prokarma.pkmst.config.YmlConfig;
import com.prokarma.pkmst.model.Stock;

import io.swagger.annotations.ApiParam;

/**
 * Api implemention
 * 
 * @author pkmst
 *
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaPKMSTServerCodegen", date = "2018-02-20T21:42:25.392Z")

@Controller
public class StockApiController implements StockApi {
	private static final int NUMBER_OF_DECIMALS = 4;
	private RestTemplate restTemplate =new RestTemplate();
	private YmlConfig ymlConfig;
	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	public void setYmlConfig(YmlConfig ymlConfig) {
		this.ymlConfig = ymlConfig;
	}

	public ResponseEntity<Stock> getStockSummaryByTicker(
			@ApiParam(value = "Ticker of the stock to return", required = true) @PathVariable("ticker") String ticker,
			@ApiParam(value = "Currency in which the stock prices will be returned", required = true) @PathVariable("currency") String currency)
			throws Exception {
		
		
		Double exchangeRate = null;
		try {
			exchangeRate = getExchangeRate(currency);
		} catch (Exception e) {
			logger.info("Exchange rate wasn't found for : " + currency);
		}
		if(exchangeRate == null) {
			return new ResponseEntity<Stock>(HttpStatus.NOT_FOUND);
		}
		
		Stock stock = null;
		try {
			stock = getStockDetail(ticker, currency);
		} catch (Exception e) {
			logger.info("Stock wasn't found for : " + ticker);
		}
		if(stock == null) {
			return new ResponseEntity<Stock>(HttpStatus.NOT_FOUND);			
		}
		
		stock.setClosingPrice(stock.getClosingPrice().multiply(new BigDecimal(exchangeRate)).setScale(NUMBER_OF_DECIMALS, RoundingMode.HALF_UP));
		stock.setOpeningPrice(stock.getOpeningPrice().multiply(new BigDecimal(exchangeRate)).setScale(4, RoundingMode.HALF_UP));
		stock.setHighPrice(stock.getHighPrice().multiply(new BigDecimal(exchangeRate)).setScale(4, RoundingMode.HALF_UP));
		stock.setLowPrice(stock.getLowPrice().multiply(new BigDecimal(exchangeRate)).setScale(4, RoundingMode.HALF_UP));
		
		return new ResponseEntity<Stock>(stock, HttpStatus.OK);
	}

	private Stock getStockDetail(String ticker, String currency) throws ParseException {
		Map<String, String> stockServiceRequestMap = Maps.newHashMap();
		stockServiceRequestMap.put("stockticker", ticker);
		String stockServiceReply = this.restTemplate.getForObject(stockServiceUrl(), String.class, stockServiceRequestMap);
		if(StringUtils.isBlank(stockServiceReply)) {
			return null;
		}
		
		
		JSONParser jsonParser = new JSONParser();
		Object json = jsonParser.parse(stockServiceReply);
		JSONObject jsonObject = (JSONObject)json;

		Double open = (Double)jsonObject.get("openingPrice");
		Double close = (Double)jsonObject.get("closingPrice");
		Double high = (Double)jsonObject.get("highPrice");
		Double low = (Double)jsonObject.get("lowPrice");
		
		String name = (String)jsonObject.get("name");
		String description = (String)jsonObject.get("description");
		String exchange = (String)jsonObject.get("exchange");

		Stock stock = new Stock();
		stock.setTicker(StringUtils.upperCase(ticker));
		stock.setCurrency(StringUtils.upperCase(currency));
		stock.setExchange(exchange);
		stock.setName(name);
		stock.setDescription(description);
		
		stock.setOpeningPrice(new BigDecimal(open));
		stock.setClosingPrice(new BigDecimal(close));
		stock.setHighPrice(new BigDecimal(high));
		stock.setLowPrice(new BigDecimal(low));
		return stock;
	}

	private Double getExchangeRate(String currency) throws ParseException {
		if(StringUtils.equalsIgnoreCase(currency, "USD")) {
			return 1.0;
		}
		Map<String, String> forexServiceRequestMap = Maps.newHashMap();		
		forexServiceRequestMap.put("forexticker", "USD" + currency);
		String forexServiceReply = this.restTemplate.getForObject(forexServiceUrl(), String.class, forexServiceRequestMap);
		if(StringUtils.isBlank(forexServiceReply)) {
			return null;
		}
		
		JSONParser jsonParser = new JSONParser();
		Object json = jsonParser.parse(forexServiceReply);
		JSONObject jsonObject = (JSONObject)json;
		return (Double)jsonObject.get("closingPrice");
	}
	
	
	private String forexServiceUrl() {
		return new StringBuilder().append(ymlConfig.getForexServiceEndPoint()).append("/forex/{forexticker}").toString();
	}
	 
	private String stockServiceUrl() {
		return new StringBuilder().append(ymlConfig.getStockServiceEndPoint()).append("/stock/{stockticker}").toString();
	}

}
