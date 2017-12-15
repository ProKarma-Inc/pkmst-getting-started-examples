package com.prokarma.pkmst.cucumber;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.junit.Rule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class UserSteps {
	final Logger logger = LoggerFactory.getLogger(UserSteps.class);
	final static int PORT = 49801;
	@Rule
	static WireMockServer wireMockServer = new WireMockServer(PORT);

	private static String URL = "http://localhost:" + PORT;
	
	@Before("@scenario-1")
	public static void setUpScenario1() {
		wireMockServer.start();
		WireMock.configureFor("localhost", PORT);
		WireMock.stubFor(WireMock.get(WireMock.urlEqualTo("/user/login"))
				.willReturn(WireMock.aResponse().withStatus(200).withHeader("Content-Type", "application/json")));
	}
	@Given("^I query to login /user/login\"$")
	public void i_query_to_login_user_login() throws Throwable {
		logger.info("Get call for " + URL);
	}

	@Then("^response status code for all users should be \"([^\"]*)\"$")
	public void response_status_code_for_all_users_should_be(String arg1) throws Throwable {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet request = new HttpGet(URL + "/user/login");
		HttpResponse response = httpClient.execute(request);

		// Status code
		assertEquals(Integer.parseInt(arg1), response.getStatusLine().getStatusCode());
	}

	@Then("^response content type for all users should be \"([^\"]*)\"$")
	public void response_content_type_for_all_users_should_be(String arg1) throws Throwable {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet request = new HttpGet(URL + "/user/login");
		HttpResponse response = httpClient.execute(request);
		// Response type
		assertEquals(arg1, response.getFirstHeader("Content-Type").getValue());
	}

	@Before("@scenario-2")
	public static void setUpScenario2() {
		wireMockServer.start();
		WireMock.configureFor("localhost", PORT);
		WireMock.stubFor(WireMock.get(WireMock.urlEqualTo("/user")).willReturn(WireMock.aResponse().withStatus(200)
				.withHeader("Content-Type", "application/json").withBody("{\"username\":\"test\"}")));
	}
	@Given("^I query to create \"([^\"]*)\"$")
	public void i_query_to_create(String arg1) throws Throwable {
		logger.info("Get call for " + URL + arg1);
	}

	@Then("^response status code for create user should be \"([^\"]*)\"$")
	public void response_status_code_for_create_user_should_be(String arg1) throws Throwable {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet request = new HttpGet(URL + "/user");
		HttpResponse response = httpClient.execute(request);

		// Status code
		assertEquals(Integer.parseInt(arg1), response.getStatusLine().getStatusCode());
	}

	@Then("^response content type for create user should be \"([^\"]*)\"$")
	public void response_content_type_for_create_user_should_be(String arg1) throws Throwable {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet request = new HttpGet(URL + "/user");
		HttpResponse response = httpClient.execute(request);
		// Response type
		assertEquals(arg1, response.getFirstHeader("Content-Type").getValue());
	}

	
	

	@Before("@scenario-3")
	public static void setUpScenario3() {
		wireMockServer.start();
		WireMock.configureFor("localhost", PORT);
		WireMock.stubFor(WireMock.delete(WireMock.urlEqualTo("/user/test"))
				.willReturn(WireMock.aResponse().withStatus(200).withHeader("Content-Type", "application/json")));
	}
	@Given("^I query to delete user \"([^\"]*)\"$")
	public void i_query_to_delete_user(String arg1) throws Throwable {
		logger.info("Get call for " + URL + arg1);
	}

	@Then("^response status code for delete user should be \"([^\"]*)\"$")
	public void response_status_code_for_delete_user_should_be(String arg1) throws Throwable {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpDelete request = new HttpDelete(URL + "/user/test");
		HttpResponse response = httpClient.execute(request);

		// Status code
		assertEquals(Integer.parseInt(arg1), response.getStatusLine().getStatusCode());
	}

	@Then("^response content type for delete user should be \"([^\"]*)\"$")
	public void response_content_type_for_delete_user_should_be(String arg1) throws Throwable {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpDelete request = new HttpDelete(URL + "/user/test");
		HttpResponse response = httpClient.execute(request);
		// Response type
		assertEquals(arg1, response.getFirstHeader("Content-Type").getValue());
	}

	@Before("@scenario-4")
	public static void setUpScenario4() {
		wireMockServer.start();
		WireMock.configureFor("localhost", PORT);
		WireMock.stubFor(WireMock.get(WireMock.urlEqualTo("/user")).willReturn(WireMock.aResponse().withStatus(200)
				.withHeader("Content-Type", "application/json").withBody("{\"username\":\"test\"}")));
	}
	@Given("^I query to get user by user name \"([^\"]*)\"$")
	public void i_query_to_get_user_by_user_name(String arg1) throws Throwable {
		logger.info("Get call for " + URL + arg1);
	}

	@Then("^response status code for get user by user name should be \"([^\"]*)\"$")
	public void response_status_code_for_get_user_by_user_name_should_be(String arg1) throws Throwable {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet request = new HttpGet(URL + "/user/test");
		HttpResponse response = httpClient.execute(request);

		// Status code
		assertEquals(Integer.parseInt(arg1), response.getStatusLine().getStatusCode());
	}

	@Then("^response content type for get user by user name should be \"([^\"]*)\"$")
	public void response_content_type_for_get_user_by_user_name_should_be(String arg1) throws Throwable {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet request = new HttpGet(URL + "/user/test");
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
			prop.load(UserSteps.class.getClassLoader()
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

