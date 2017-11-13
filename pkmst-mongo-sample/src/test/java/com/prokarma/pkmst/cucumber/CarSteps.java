package com.prokarma.pkmst.cucumber;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.junit.Rule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.prokarma.pkmst.model.Car;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class CarSteps {
	final Logger logger = LoggerFactory.getLogger(CarSteps.class);
	final static int PORT = 49801;
	@Rule
	static WireMockServer wireMockServer = new WireMockServer(PORT);

	private static String URL = "http://localhost:" + PORT;
	
	@Given("^I query to display all cars \"([^\"]*)\"$")
	public void i_query_to_display_all_cars(String arg1) throws Throwable {
		logger.info("Get call for " + URL + arg1);
	}

	@Before("@scenario-1")
	public static void setUpScenario1() {
		wireMockServer.start();
		WireMock.configureFor("localhost", PORT);
		WireMock.stubFor(WireMock.get(WireMock.urlEqualTo("/car/allCars"))
				.willReturn(WireMock.aResponse().withStatus(200).withHeader("Content-Type", "application/json")));
	}

	@Then("^response status code for all cars should be \"([^\"]*)\"$")
	public void response_status_code_for_get_should_be(String arg1) throws Throwable {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet request = new HttpGet(URL + "/car/allCars");
		HttpResponse response = httpClient.execute(request);

		// Status code
		assertEquals(Integer.parseInt(arg1), response.getStatusLine().getStatusCode());
	}

	@Then("^response content type for all cars should be \"([^\"]*)\"$")
	public void response_content_type_for_get_should_be(String arg1) throws Throwable {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet request = new HttpGet(URL + "/car/allCars");
		HttpResponse response = httpClient.execute(request);
		// Response type
		assertEquals(arg1, response.getFirstHeader("Content-Type").getValue());
	}
	

	@Given("^I query to create \"([^\"]*)\"$")
	public void i_query_to_create(String arg1) throws Throwable {
		logger.info("Get call for " + URL + arg1);

	}
	
	@Before("@scenario-2")
	public static void setUpScenario2() throws Throwable {
		Car newCar = new Car(110l,"v110","Swift", "Ss", 2011);		
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(newCar);
		wireMockServer.start();
		WireMock.configureFor("localhost", PORT);
		WireMock.stubFor(WireMock.get(WireMock.urlEqualTo("/car"))
				.willReturn(WireMock.aResponse().withStatus(200).withHeader("Content-Type", "application/json").withBody(json)));
		
	}	

	@Then("^response status code for create car should be \"([^\"]*)\"$")
	public void response_status_code_for_create_car_should_be(String arg1)
			throws Throwable {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet request = new HttpGet(URL + "/car");
		HttpResponse response = httpClient.execute(request);

		// Status code
		assertEquals(Integer.parseInt(arg1), response.getStatusLine().getStatusCode());
	}

	@Then("^response content type for create car should be \"([^\"]*)\"$")
	public void response_content_type_for_create_car_should_be(String arg1)
			throws Throwable {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet request = new HttpGet(URL + "/car");
		HttpResponse response = httpClient.execute(request);
		// Response type
		assertEquals(arg1, response.getFirstHeader("Content-Type").getValue());
	}
	
	@Given("^I query to create cars with array \"([^\"]*)\"$")
	public void i_query_to_create_cars_with_array(String arg1) throws Throwable {
		logger.info("Get call for " + URL + arg1);
	}
	
	@Before("@scenario-3")
	public static void setUpScenario3() throws Throwable {
		List<Car> carsList = new ArrayList<Car>();
		Car newCar = new Car(111l,"v111","Swift1", "Ss1", 2011);		
		carsList.add(newCar);
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(newCar);
		wireMockServer.start();
		WireMock.configureFor("localhost", PORT);
		WireMock.stubFor(WireMock.get(WireMock.urlEqualTo("/car/createWithArray"))
				.willReturn(WireMock.aResponse().withStatus(200).withHeader("Content-Type", "application/json")));
	}

	@Then("^response status code for create cars with array should be \"([^\"]*)\"$")
	public void response_status_code_for_create_cars_with_array_should_be(String arg1) throws Throwable {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet request = new HttpGet(URL + "/car/createWithArray");
		HttpResponse response = httpClient.execute(request);

		// Status code
		assertEquals(Integer.parseInt(arg1), response.getStatusLine().getStatusCode());
	}

	@Then("^response content type for create cars with array should be \"([^\"]*)\"$")
	public void response_content_type_for_create_cars_with_array_should_be(String arg1) throws Throwable {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet request = new HttpGet(URL + "/car/createWithArray");
		HttpResponse response = httpClient.execute(request);
		// Response type
		assertEquals(arg1, response.getFirstHeader("Content-Type").getValue());
	}

	@Given("^I query to delete car \"([^\"]*)\"$")
	public void i_query_to_delete_car(String arg1) throws Throwable {
		logger.info("Get call for " + URL + arg1);
	}
	
	@Before("@scenario-4")
	public static void setUpScenario4() {
		wireMockServer.start();
		WireMock.configureFor("localhost", PORT);
		WireMock.stubFor(WireMock.get(WireMock.urlEqualTo("/car/v101"))
				.willReturn(WireMock.aResponse().withStatus(200).withHeader("Content-Type", "application/json")));
	}

	@Then("^response status code for delete car should be \"([^\"]*)\"$")
	public void response_status_code_for_delete_car_should_be(String arg1) throws Throwable {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpDelete request = new HttpDelete(URL + "/car/v101");
		HttpResponse response = httpClient.execute(request);

		// Status code
		assertEquals(Integer.parseInt(arg1), response.getStatusLine().getStatusCode());
	}

	@Then("^response content type for delete car should be \"([^\"]*)\"$")
	public void response_content_type_for_delete_car_should_be(String arg1) throws Throwable {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpDelete request = new HttpDelete(URL + "/car/v101");
		HttpResponse response = httpClient.execute(request);
		// Response type
		assertEquals(arg1, response.getFirstHeader("Content-Type").getValue());
	}

	@Given("^I query to get car by vin number \"([^\"]*)\"$")
	public void i_query_to_get_car_by_vin_number(String arg1) throws Throwable {
		logger.info("Get call for " + URL + arg1);
	}
	
	@Before("@scenario-5")
	public static void setUpScenario5() {
		wireMockServer.start();
		WireMock.configureFor("localhost", PORT);
		WireMock.stubFor(WireMock.get(WireMock.urlEqualTo("/car/v101"))
				.willReturn(WireMock.aResponse().withStatus(200).withHeader("Content-Type", "application/json")));
	}

	@Then("^response status code for get car by vin number should be \"([^\"]*)\"$")
	public void response_status_code_for_get_car_by_vin_number_should_be(String arg1) throws Throwable {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet request = new HttpGet(URL + "/car/v101");
		HttpResponse response = httpClient.execute(request);

		// Status code
		assertEquals(Integer.parseInt(arg1), response.getStatusLine().getStatusCode());
	}

	@Then("^response content type for get car by vin numberr should be \"([^\"]*)\"$")
	public void response_content_type_for_get_car_by_vin_numberr_should_be(String arg1) throws Throwable {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet request = new HttpGet(URL + "/car/v101");
		HttpResponse response = httpClient.execute(request);
		// Response type
		assertEquals(arg1, response.getFirstHeader("Content-Type").getValue());
	}

	@Given("^I query to updated car \"([^\"]*)\"$")
	public void i_query_to_updated_car(String arg1) throws Throwable {
		logger.info("Get call for " + URL + arg1);
	}
	
	@Before("@scenario-6")
	public static void setUpScenario6() {
		wireMockServer.start();
		WireMock.configureFor("localhost", PORT);
		WireMock.stubFor(WireMock.get(WireMock.urlEqualTo("/car/v101"))
				.willReturn(WireMock.aResponse().withStatus(200).withHeader("Content-Type", "application/json")));
	}

	@Then("^response status code for updated car should be \"([^\"]*)\"$")
	public void response_status_code_for_updated_car_should_be(String arg1) throws Throwable {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet request = new HttpGet(URL + "/car/v101");
		HttpResponse response = httpClient.execute(request);

		// Status code
		assertEquals(Integer.parseInt(arg1), response.getStatusLine().getStatusCode());
	}

	@Then("^response content type for updated car should be \"([^\"]*)\"$")
	public void response_content_type_for_updated_car_should_be(String arg1) throws Throwable {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet request = new HttpGet(URL + "/car/v101");
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
			prop.load(CarSteps.class.getClassLoader()
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

