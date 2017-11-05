package com.prokarma.pkmst.controller;
import java.util.List;

import org.json.JSONException;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
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
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PkmstIT {

	@LocalServerPort
	private int port;

	TestRestTemplate restTemplate = new TestRestTemplate();

	HttpHeaders headers = new HttpHeaders();

	@Test
	public void testRetrieveStudentCourse() {

	}
	
	@Test
	public void testAllStudents() throws JSONException {

		HttpEntity<String> entity = new HttpEntity<String>(null, headers);

		ResponseEntity<List> response = restTemplate.exchange(
				createURLWithPort("/car/allCars"),
				HttpMethod.GET, entity, List.class);
		
		Assert.assertEquals(3, response.getBody().size());
	}
	
	@Test
	public void testCreateCar() throws JSONException {

		Car newCar =  new Car(104l,"v104","Nissan", "Rogue", 2017);
		headers.add("Content-Type", "application/json");
		HttpEntity<Car> createEntity = new HttpEntity<Car>(newCar, headers);
		
		ResponseEntity<String> response = restTemplate.exchange(
				createURLWithPort("/car"),
				HttpMethod.POST, createEntity, String.class);
		System.out.println(response);
		Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
	}
	
	
	

	private String createURLWithPort(String uri) {
		return "http://localhost:" + port + uri;
	}
}