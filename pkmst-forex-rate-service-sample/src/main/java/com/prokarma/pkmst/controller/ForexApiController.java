package com.prokarma.pkmst.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;

import com.prokarma.pkmst.dao.IForexDao;
import com.prokarma.pkmst.model.Forex;

import io.swagger.annotations.ApiParam;

/**
 * Api implemention
 * 
 * @author pkmst
 *
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaPKMSTServerCodegen", date = "2018-02-20T12:58:06.831Z")

@Controller
public class ForexApiController implements ForexApi {
	private IForexDao forexDao;

	@Autowired
	public void setForexDao(IForexDao forexDao) {
		this.forexDao = forexDao;
	}

	public ResponseEntity<Forex> getForexSummaryByTicker(
			@ApiParam(value = "Ticker of the stock to return", required = true) @PathVariable("ticker") String ticker)
			throws Exception {
    	Forex forex = this.forexDao.getByTicker(ticker);
    	if(forex == null) {
    		return new ResponseEntity<Forex>(HttpStatus.NOT_FOUND);
    	}
        return new ResponseEntity<Forex>(forex, HttpStatus.OK);
	}

}
