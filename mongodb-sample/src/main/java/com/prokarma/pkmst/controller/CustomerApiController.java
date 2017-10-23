package com.prokarma.pkmst.controller;

import java.util.List;

import io.swagger.annotations.ApiParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.prokarma.pkmst.model.Customer;
import com.prokarma.pkmst.model.CustomerRepository;

/**
 * Api implemention
 * 
 * @author pkmst
 *
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.PkmstServerCodegen", date = "2017-10-13T15:19:53.170Z")
@Controller
public class CustomerApiController implements CustomerApi {
	private final ObjectMapper objectMapper;

	@Autowired
	CustomerRepository repository;

	@Autowired
	public CustomerApiController(ObjectMapper objectMapper) {
		this.objectMapper = objectMapper;
	}

	public ResponseEntity<Customer> getCustomerById(
			@ApiParam(value = "ID of customer to return", required = true) @PathVariable("customerId") Long customerId)
			throws Exception {
		return new ResponseEntity<Customer>(repository.findOne(customerId),
				HttpStatus.OK);
	}

	public ResponseEntity<List<Customer>> getCustomerByLoc(
			@ApiParam(value = "Location of Customers to return", required = true) @PathVariable("customerLoc") String customerLoc)
			throws Exception {
		return new ResponseEntity<List<Customer>>(
				repository.findByLocation(customerLoc), HttpStatus.OK);
	}

}
