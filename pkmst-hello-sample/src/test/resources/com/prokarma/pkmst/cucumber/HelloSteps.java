package com.prokarma.pkmst.cucumber;

import static com.jayway.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.junit.Rule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.jayway.restassured.response.Response;
import com.prokarma.pkmst.model.Student;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class StudentSteps {
	final Logger logger = LoggerFactory.getLogger(StudentSteps.class);
	final static int PORT = 49801;
	@Rule
	static WireMockServer wireMockServer = new WireMockServer(PORT);

	private static String URL = "http://localhost:" + PORT;
	
	@Given("^I query to greet testuser \"([^\"]*)\"$")
	public void i_query_to_greet_testuser(String arg1) throws Throwable {
		logger.info("Get call for " + URL + arg1);
	}

	@Before("@scenario-1")
	public static void setUpScenario1() {
		wireMockServer.start();
		WireMock.configureFor("localhost", PORT);
		WireMock.stubFor(WireMock.get(WireMock.urlEqualTo("/hello/testuser"))
				.willReturn(WireMock.aResponse().withStatus(200).withHeader("Content-Type", "application/json")));
		
	}
	

	@Then("^response status code for get should be \"([^\"]*)\"$")
	public void response_status_code_for_get_should_be(String arg1) throws Throwable {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet request = new HttpGet(URL + "/hello/testuser");
		HttpResponse response = httpClient.execute(request);

		// Status code
		assertEquals(Integer.parseInt(arg1), response.getStatusLine().getStatusCode());
	}

	@Then("^response content type for get should be \"([^\"]*)\"$")
	public void response_content_type_for_get_should_be(String arg1) throws Throwable {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet request = new HttpGet(URL + "/hello/testuser");
		HttpResponse response = httpClient.execute(request);
		// Response type
		assertEquals(arg1, response.getFirstHeader("Content-Type").getValue());
	}
	
	//Method to return get the properties from Properties file
	public String getProperties(String keyValue) {
		String url = null;
		Properties prop = new Properties();
		InputStream input = null;
		try {
			prop.load(StudentSteps.class.getClassLoader()
                    .getResourceAsStream("testconfig.properties"));
			url = prop.getProperty(keyValue);
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return url;
	}

	@After
	public static void cleanUP() {
		wireMockServer.stop();
	}

}

