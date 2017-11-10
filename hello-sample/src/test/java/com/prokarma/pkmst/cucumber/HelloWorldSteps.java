package com.prokarma.pkmst.cucumber;

import static org.junit.Assert.assertEquals;

import org.apache.http.HttpResponse;
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

public class HelloWorldSteps {
	final Logger logger = LoggerFactory.getLogger(HelloWorldSteps.class);
	final static int PORT = 49801;
	@Rule
	static WireMockServer wireMockServer = new WireMockServer(PORT);

	private static String URL = "http://localhost:" + PORT;

	@Before("@scenario-1")
	public static void setUpScenario1() {
		wireMockServer.start();
		WireMock.configureFor("localhost", PORT);
		WireMock.stubFor(
				WireMock.get(WireMock.urlEqualTo("/user/sayHello")).willReturn(WireMock.aResponse().withStatus(200)));

	}

	@Given("^I query to sayHello \"([^\"]*)\"$")
	public void i_query_to_sayHello(String arg1) throws Throwable {
		logger.info("Call for " + URL + arg1);
	}

	@Then("^response status code for sayHello should be \"([^\"]*)\"$")
	public void response_status_code_for_sayHello_should_be(String arg1) throws Throwable {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet request = new HttpGet(URL + "/user/sayHello");
		HttpResponse response = httpClient.execute(request);

		// Status code
		assertEquals(Integer.parseInt(arg1), response.getStatusLine().getStatusCode());
	}

	@Before("@scenario-2")
	public static void setUpScenario2() {
		wireMockServer.start();
		WireMock.configureFor("localhost", PORT);
		WireMock.stubFor(WireMock.get(WireMock.urlEqualTo("/user/hello"))
				.willReturn(WireMock.aResponse().withStatus(200).withBody("{\"name\":\"TestUser\"}")));
	}

	@Given("^I query to hello \"([^\"]*)\"$")
	public void i_query_to_hello(String arg1) throws Throwable {
		logger.info("Call for " + URL + arg1);
	}

	@Then("^response status code for hello should be \"([^\"]*)\"$")
	public void response_status_code_for_hello_should_be(String arg1) throws Throwable {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet request = new HttpGet(URL + "/user/hello");
		HttpResponse response = httpClient.execute(request);

		// Status code
		assertEquals(Integer.parseInt(arg1), response.getStatusLine().getStatusCode());
	}

	@After
	public static void cleanUP() {
		wireMockServer.stop();
	}

}
