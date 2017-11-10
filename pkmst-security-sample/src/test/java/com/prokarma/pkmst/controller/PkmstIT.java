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
		Assert.assertNotNull(response);
	}
	
	@Test
	public void testCreateUser() throws JSONException {

		HttpEntity<String> entity = new HttpEntity<String>(null, headers);

		User newUser =  new User("testuser1", "testuser1", "USER");
		
		headers.add("Content-Type", "application/json");
		HttpEntity<User> createEntity = new HttpEntity<User>(newUser, headers);
		
		ResponseEntity<String> response = restTemplate.exchange(
				createURLWithPort("/user"),
				HttpMethod.POST, createEntity, String.class);
		Assert.assertEquals("testuser1user registered with the system", response.getBody());
	}
	
	@Test
	public void testCreateUsersWithArrayInput() throws JSONException {
		
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);
		User newUser =  new User("testuser2", "testuser2", "USER");
		
		headers.add("Content-Type", "application/json");
		
		List<User> usersList = new ArrayList<User>();
		usersList.add(newUser);
		headers.add("Content-Type", "application/json");
		HttpEntity<List<User>> createEntity = new HttpEntity<List<User>>(usersList, headers);
		
		ResponseEntity<String> response = restTemplate.exchange(
				createURLWithPort("/user/createWithArray"),
				HttpMethod.POST, createEntity, String.class);
		Assert.assertEquals("User(s) registered with the system", response.getBody());
	}
	
	@Test
	public void testCreateUsersWithListInput() throws JSONException {
		
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);
		User newUser =  new User("testuser3", "testuser3", "USER");
		
		headers.add("Content-Type", "application/json");
		
		List<User> usersList = new ArrayList<User>();
		usersList.add(newUser);
		headers.add("Content-Type", "application/json");
		HttpEntity<List<User>> createEntity = new HttpEntity<List<User>>(usersList, headers);
		
		ResponseEntity<String> response = restTemplate.exchange(
				createURLWithPort("/user/createWithList"),
				HttpMethod.POST, createEntity, String.class);
		Assert.assertEquals("User(s) registered with the system", response.getBody());
	}
	
	
	@Test
	public void testGetUserbyName() throws JSONException {

		HttpEntity<String> entity = new HttpEntity<String>(null, headers);
		
		ResponseEntity<User> response = restTemplate.exchange(
				createURLWithPort("/user/user"),
				HttpMethod.GET, entity, User.class);
		Assert.assertNotNull(response.getBody());
	}
	
	@Test
	public void testDeleteUser() throws JSONException {

		HttpEntity<String> entity = new HttpEntity<String>(null, headers);
		
		ResponseEntity<String> response = restTemplate.exchange(
				createURLWithPort("/user/user"),
				HttpMethod.DELETE, entity, String.class);
		Assert.assertEquals("user deleted successfully from the system", response.getBody());
	}
	
	@Test
	public void testUpdateUser() throws JSONException {

		HttpEntity<String> entity = new HttpEntity<String>(null, headers);
		
		User newUser =  new User("testuser", "testuser1", "USER");
		headers.add("Content-Type", "application/json");
		HttpEntity<User> createEntity = new HttpEntity<User>(newUser, headers);
		
		ResponseEntity<String> response = restTemplate.exchange(
				createURLWithPort("/user/testuser"),
				HttpMethod.PUT, createEntity, String.class);
		Assert.assertEquals("User information modified successfully.", response.getBody());
	}
	
	@Test
	public void testLogout() throws JSONException {

		HttpEntity<String> entity = new HttpEntity<String>(null, headers);

		ResponseEntity<String> response = restTemplate.exchange(
				createURLWithPort("/user/logout"),
				HttpMethod.GET, entity, String.class);
		Assert.assertNotNull(response);
	}

	private String createURLWithPort(String uri) {
		return "http://localhost:" + port + uri;
	}
}