/*
 * Equity Price Lookup
 * Equity Price Lookup
 *
 * OpenAPI spec version: 1.0.0
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package com.prokarma.pkmst.controller;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.http.ResponseEntity;

import com.prokarma.pkmst.model.Stock;

/**
 * API tests for StockApi
 */
@Ignore
public class StockApiTest {

	private final StockApi api = new StockApiController();

	/**
	 * Lookup a stock detail by the ticker and currency
	 *
	 * Returns a single stock price in currency of choice
	 *
	 * @throws Exception
	 *             if the Api call fails
	 */
	@Test
	public void getStockSummaryByTickerTest() throws Exception {
		String ticker = null;
		String currency = null;
		ResponseEntity<Stock> response = api.getStockSummaryByTicker(ticker, currency);

		// TODO: test validations
	}

}
