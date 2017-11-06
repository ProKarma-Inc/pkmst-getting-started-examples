package com.prokarma.pkmst.controller;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.prokarma.pkmst.PkmstApplication;
import com.prokarma.pkmst.model.Car;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = PkmstApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PkmstIT {

	@LocalServerPort
	private int port;

	TestRestTemplate restTemplate = new TestRestTemplate();

	HttpHeaders headers = new HttpHeaders();

	@Test
	public void testAllCars() throws JSONException {

		HttpEntity<String> entity = new HttpEntity<String>(null, headers);

		ResponseEntity<List> response = restTemplate.exchange(
				createURLWithPort("/car/allCars"),
				HttpMethod.GET, entity, List.class);		
		Assert.assertNotNull(response.getBody());
	}
	
	@Test
	public void testGetCarByVinNumber() throws JSONException {

		HttpEntity<String> entity = new HttpEntity<String>(null, headers);

		ResponseEntity<Car> response = restTemplate.exchange(
				createURLWithPort("/car/v102"),
				HttpMethod.GET, entity, Car.class);		
		Assert.assertEquals("v102", response.getBody().getVinNumber());
	}
	
	@Test
	public void testCreateCar() throws JSONException {

		Car newCar =  new Car("v104","Nissan", "Rogue", 2017);
		headers.add("Content-Type", "application/json");
		HttpEntity<Car> createEntity = new HttpEntity<Car>(newCar, headers);
		
		ResponseEntity<String> response = restTemplate.exchange(
				createURLWithPort("/car"),
				HttpMethod.POST, createEntity, String.class);
		Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
	}
	
	@Test
	public void testDeleteCar() throws JSONException {

		
		headers.add("Content-Type", "application/json");
		HttpEntity<Car> createEntity = new HttpEntity<Car>(null, headers);
		
		ResponseEntity<String> response = restTemplate.exchange(
				createURLWithPort("/car/v104"),
				HttpMethod.GET, createEntity, String.class);
		Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
	}
	
	@Test
	public void testUpdateCar() throws JSONException {

		Car newCar =  new Car("v101","HondaNew", "Civic", 2000);
		headers.add("Content-Type", "application/json");
		HttpEntity<Car> createEntity = new HttpEntity<Car>(newCar, headers);
		
		ResponseEntity<String> response = restTemplate.exchange(
				createURLWithPort("/car/v101"),
				HttpMethod.PUT, createEntity, String.class);
		System.out.println(response);
		Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
	}
	
	@Test
	public void testCreateCarsWithArrayInput() throws JSONException {

		Car newCar =  new Car("v105","Toyota", "Camry", 2009);
		List<Car> carsList = new ArrayList<Car>();
		carsList.add(newCar);
		headers.add("Content-Type", "application/json");
		HttpEntity<List<Car>> createEntity = new HttpEntity<List<Car>>(carsList, headers);
		
		ResponseEntity<String> response = restTemplate.exchange(
				createURLWithPort("/car/createWithArray"),
				HttpMethod.POST, createEntity, String.class);
		Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
	}

	private String createURLWithPort(String uri) {
		return "http://localhost:" + port + uri;
	}
}