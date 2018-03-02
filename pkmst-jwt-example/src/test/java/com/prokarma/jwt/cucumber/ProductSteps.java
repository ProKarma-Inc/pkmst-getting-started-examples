package com.prokarma.jwt.cucumber;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

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
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import static com.jayway.restassured.RestAssured.given;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import com.jayway.restassured.response.Response;
import com.prokarma.product.pkmst.dto.ProductDto;

public class ProductSteps {
	final Logger logger = LoggerFactory.getLogger(ProductSteps.class);
	final static int PORT = 49800;
	@Rule
	static WireMockServer wireMockServer = new WireMockServer(PORT);

	private static String URL = "http://localhost:" + PORT;

	@Before("@scenario-1")
	public static void setUpScenario1() {
		wireMockServer.start();
		WireMock.configureFor("localhost", PORT);
		WireMock.stubFor(WireMock.get(WireMock.urlEqualTo("/products"))
				.willReturn(WireMock.aResponse().withStatus(200).withHeader("Content-Type", "application/json")));
	}

	@Given("^I query to all products \"([^\"]*)\"$")
	public void i_query_to_all_products(String arg1) throws Throwable {
		logger.info("Get call for " + URL + arg1);
	}

	@Before("@scenario-2")
	public static void setUpScenario2() {
		wireMockServer.start();
		WireMock.configureFor("localhost", PORT);
		WireMock.stubFor(WireMock.get(WireMock.urlEqualTo("/products")).willReturn(WireMock.aResponse().withStatus(200)
				.withHeader("Content-Type", "application/json").withBody("{\"product-id\":\"100\"}")));
	}

	@Given("^I query to product-id\"([^\"]*)\"$")
	public void i_query_to_product_id(String arg1) throws Throwable {
		logger.info("Get call for " + URL + arg1);
	}

	@Then("^response status code for get should be \"([^\"]*)\"$")
	public void response_status_code_for_get_should_be(String arg1) throws ClientProtocolException, IOException {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet request = new HttpGet(URL + "/products");
		HttpResponse response = httpClient.execute(request);

		// Status code
		assertEquals(Integer.parseInt(arg1), response.getStatusLine().getStatusCode());

	}

	@Then("^response content type for get should be \"([^\"]*)\"$")
	public void response_content_type_for_get_should_be(String arg1) throws ClientProtocolException, IOException {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet request = new HttpGet(URL + "/products");
		HttpResponse response = httpClient.execute(request);
		// Response type
		assertEquals(arg1, response.getFirstHeader("Content-Type").getValue());
	}

	@Before("@scenario-3")
	public static void setUpScenario3() {
		wireMockServer.start();
		WireMock.configureFor("localhost", PORT);
		WireMock.stubFor(WireMock.delete(WireMock.urlEqualTo("/products/100"))
				.willReturn(WireMock.aResponse().withStatus(200).withHeader("Content-Type", "application/json")));
	}

	@Given("^I query to delete product-id \"([^\"]*)\"$")
	public void i_query_to_delete_product_id(String arg1) {
		logger.info("Get call for " + URL + arg1);
	}

	@Then("^response status code delete should be \"([^\"]*)\"$")
	public void response_status_code_delete_should_be(String arg1) throws ClientProtocolException, IOException {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpDelete request = new HttpDelete(URL + "/products/100");
		HttpResponse response = httpClient.execute(request);

		// Status code
		assertEquals(Integer.parseInt(arg1), response.getStatusLine().getStatusCode());

	}

	@Then("^response content type for delete should be \"([^\"]*)\"$")
	public void response_content_type_for_delete_should_be(String arg1) throws ClientProtocolException, IOException {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpDelete request = new HttpDelete(URL + "/products/100");
		HttpResponse response = httpClient.execute(request);
		// Response type
		assertEquals(arg1, response.getFirstHeader("Content-Type").getValue());
	}

	@Before("@scenario-4")
	public static void setUpScenario4() throws JsonProcessingException {
		ProductDto productDto = new ProductDto();
		productDto.setId(100L);
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(productDto);

		wireMockServer.start();
		WireMock.configureFor("localhost", PORT);
		WireMock.stubFor(WireMock.post(WireMock.urlEqualTo("/products")).willReturn(
				WireMock.aResponse().withStatus(201).withHeader("Content-Type", "application/json").withBody(json)));

	}

	@Given("^I query to add \"([^\"]*)\"$")
	public void i_query_to_add(String arg1) throws Throwable {
		logger.info("Get call for " + URL + arg1);
	}

	@Then("^response status code post  should be \"([^\"]*)\"$")
	public void response_status_code_post_should_be(String arg1) throws ClientProtocolException, IOException {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpPost request = new HttpPost(URL + "/products");
		ProductDto productDto = new ProductDto();
		productDto.setId(100L);
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(productDto);

		StringEntity entity = new StringEntity(json);
		request.addHeader("content-type", "application/json");
		request.setEntity(entity);
		HttpResponse response = httpClient.execute(request);
		// Status code
		assertEquals(Integer.parseInt(arg1), response.getStatusLine().getStatusCode());

	}

	@Then("^response content type for post should be \"([^\"]*)\"$")
	public void response_content_type_for_post_should_be(String arg1) throws ClientProtocolException, IOException {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpPost request = new HttpPost(URL + "/products");
		ProductDto productDto = new ProductDto();
		productDto.setId(100L);
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(productDto);

		StringEntity entity = new StringEntity(json);
		request.addHeader("content-type", "application/json");
		request.setEntity(entity);
		HttpResponse response = httpClient.execute(request);
		// Response type
		assertEquals(arg1, response.getFirstHeader("Content-Type").getValue());
	}
	
	//Author : V Sreekanth
	@Given("^I hit the Url \"([^\"]*)\"$")
	public void i_hit_the_Url(String keyValue) throws ClientProtocolException, IOException {
		String url = getProperties(keyValue);
		logger.info("Hit the Url: "+ url);
	}
	
	//Author : V Sreekanth
	@Then("^response status code for get url should be \"([^\"]*)\", \"([^\"]*)\"$")
	public void response_status_code_for_get_url_should_be(String statusCode, String keyValue) throws ClientProtocolException, IOException {
		String url = getProperties(keyValue);
		Response response =
                given().get(url)
                        .then().extract().response();
		assertEquals(Integer.parseInt(statusCode), response.getStatusCode());
	}
	
	//Author : V Sreekanth
	//Method to return get the properties from Properties file
	public String getProperties(String keyValue) {
		String url = null;
		Properties prop = new Properties();
		InputStream input = null;
		try {
			prop.load(ProductSteps.class.getClassLoader()
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

