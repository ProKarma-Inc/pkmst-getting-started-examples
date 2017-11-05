package com.prokarma.pkmst.controller;
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
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.prokarma.pkmst.PkmstApplication;
import com.prokarma.pkmst.model.User;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = PkmstApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PkmstIT {

	@LocalServerPort
	private int port;

	TestRestTemplate restTemplate = new TestRestTemplate();

	HttpHeaders headers = new HttpHeaders();

	@Test
	public void testLogin() throws JSONException {

		HttpEntity<String> entity = new HttpEntity<String>(null, headers);

		ResponseEntity<String> response = restTemplate.exchange(
				createURLWithPort("/user/login?username=user&password=user"),
				HttpMethod.GET, entity, String.class);
		Assert.assertEquals("User logged in successfully into the system", response.getBody());
	}
	
	@Test
	public void testCreateUser() throws JSONException {

		HttpEntity<String> entity = new HttpEntity<String>(null, headers);

		restTemplate.exchange(
				createURLWithPort("/user/login?username=user&password=user"),
				HttpMethod.GET, entity, String.class);
		User newUser =  new User("testuser", "testuser", "USER");
		
		headers.add("Content-Type", "application/json");
		HttpEntity<User> createEntity = new HttpEntity<User>(newUser, headers);
		
		ResponseEntity<String> response = restTemplate.exchange(
				createURLWithPort("/user"),
				HttpMethod.POST, createEntity, String.class);
		Assert.assertEquals("testuseruser registered with the system", response.getBody());
	}
	
	@Test
	public void testGetUserbyName() throws JSONException {

		HttpEntity<String> entity = new HttpEntity<String>(null, headers);
		
		restTemplate.exchange(
				createURLWithPort("/user/login?username=user&password=user"),
				HttpMethod.GET, entity, String.class);

		ResponseEntity<User> response = restTemplate.exchange(
				createURLWithPort("/user/user"),
				HttpMethod.GET, entity, User.class);
		Assert.assertNotNull(response.getBody());
		Assert.assertEquals("user", response.getBody().getUsername());
	}

	private String createURLWithPort(String uri) {
		return "http://localhost:" + port + uri;
	}
}