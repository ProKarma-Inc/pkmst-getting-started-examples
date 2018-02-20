package com.prokarma.pkmst.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;

import com.prokarma.pkmst.dao.IStockDao;
import com.prokarma.pkmst.model.Stock;

import io.swagger.annotations.ApiParam;
/**
 * Api implemention
 * @author pkmst
 *
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaPKMSTServerCodegen", date = "2018-02-15T21:21:34.533Z")

@Controller
public class StockApiController implements StockApi {
    private IStockDao stockDao;
    
    
    @Autowired
    public void setStockDao(IStockDao stockDao) {
		this.stockDao = stockDao;
	}

    public ResponseEntity<Stock> getStockSummaryByTicker(@ApiParam(value = "Ticker of the stock to return",required=true ) @PathVariable("ticker") String ticker) throws Exception {
    	Stock stock = this.stockDao.findByTicker(ticker);
    	if(stock == null) {
    		return new ResponseEntity<Stock>(HttpStatus.NOT_FOUND);
    	}
        return new ResponseEntity<Stock>(stock, HttpStatus.OK);
    }

}
