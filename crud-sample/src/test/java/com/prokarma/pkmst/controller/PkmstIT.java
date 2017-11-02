package com.prokarma.pkmst.controller;
import static org.junit.Assert.assertTrue;

import org.json.JSONException;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.prokarma.pkmst.PkmstApplication;
import com.prokarma.pkmst.model.Student;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = PkmstApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PkmstIT {

	@LocalServerPort
	private int port;

	TestRestTemplate restTemplate = new TestRestTemplate();

	HttpHeaders headers = new HttpHeaders();

	@Test
	public void testAllStudents() throws JSONException {

		HttpEntity<String> entity = new HttpEntity<String>(null, headers);

		ResponseEntity<String> response = restTemplate.exchange(
				createURLWithPort("/students"),
				HttpMethod.GET, entity, String.class);
		String expected ="[\r\n  {\r\n    \"id\": 1,\r\n    \"name\": \"Phil\",\r\n    \"email\": \"phil@email.com\"\r\n  },\r\n  {\r\n    \"id\": 2,\r\n    \"name\": \"Josh\",\r\n    \"email\": \"josh@email.com\"\r\n  }\r\n]";
		JSONAssert.assertEquals(expected, response.getBody(), false);
	}
	
	@Test
	public void testGetStudentById() throws JSONException {
		headers.add("Accept", "application/json");
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);

		ResponseEntity<String> response = restTemplate.exchange(
				createURLWithPort("/students/1"),
				HttpMethod.GET, entity, String.class);
		String expected = "{\"id\": 1,\"name\": \"Phil\",\"email\": \"phil@email.com\"}";
		JSONAssert.assertEquals(expected, response.getBody(), false);
	}
	
	@Test
	public void testCreateStudent() throws JSONException {
		
		Student student = new Student("anshu", "anshu@gmail.com");
		headers.add("Content-Type", "application/json");
		HttpEntity<Student> entity = new HttpEntity<Student>(student, headers);

		ResponseEntity<String> response = restTemplate.exchange(
				createURLWithPort("/students"),
				HttpMethod.POST, entity, String.class);
		String actual = response.getBody();
		System.out.println("response.getBody():::"+response.getBody());
		assertTrue(actual.contains("Student Registered Successfully"));
	}

	private String createURLWithPort(String uri) {
		return "http://localhost:" + port + uri;
	}
	 
}
