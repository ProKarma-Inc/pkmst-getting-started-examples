/**
 * 
 */
package com.prokarma.pkmst.cucumber;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import org.apache.commons.codec.binary.Base64;
import org.hamcrest.CoreMatchers;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.HttpClientErrorException;

import com.prokarma.pkmst.pkmst.oauth.BaseTest;
import com.prokarma.pkmst.pkmst.oauth.BaseTest.TestConstants;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
/**
 * @author vsreekanth
 *
 */

public class SecuritySteps extends BaseTest {

	final Logger logger = LoggerFactory.getLogger(SecuritySteps.class);
	
	@Given("^Unauthorized access for REST Service$")
	public void unauthorized_access_for_REST_Service(){
		logger.info("Test Unauthorized access for REST Service ");
	}
	
	@Then("^except status code should be \"([^\"]*)\"$")
	public void except_status_code_should_be(String arg){
		thrown.expect(HttpClientErrorException.class);
		thrown.expectMessage(arg); 
		HttpEntity<?> request = new HttpEntity<>(getHttpHeaders());
		try{
			REST_TEMPLATE.exchange(TestConstants.BASEURI.getValue()+TestConstants.PRODUCTS.getValue(), HttpMethod.GET, request, String.class);
		}
		catch(HttpClientErrorException e){
			
		}
	}
	
	@Given("^Invalid User Credentials$")
	public void invalid_User_Credentials() {
		logger.info("Test Invalid User Credentials");
	}
	
	
	@Then("^Invalid User Credentials status code should be \"([^\"]*)\"$")
	public void invalid_User_Credentials_status_code_should_be(String arg) {
		thrown.expect(HttpClientErrorException.class);
		thrown.expectMessage(arg); 
		HttpHeaders httpHeaders = getHttpHeaders(); 
		httpHeaders.add(TestConstants.AUTH.getValue(), TestConstants.BASIC.getValue()+getEncodedCredentials());
		HttpEntity<?> request = new HttpEntity<>(httpHeaders);
		try{
			REST_TEMPLATE.exchange(TestConstants.BASEURI.getValue()+TestConstants.INVALID_USER_URL.getValue(), HttpMethod.POST, request, String.class);
		}catch(HttpClientErrorException e){
			
		}
		
	}
	
	@Given("^Invalid OAUTH2 Credentials$")
	public void invalid_OAUTH2_Credentials() {
		logger.info("Test Invalid OAUTH2 Credentials");
	}
	
	
	@Then("^Invalid OAUTH2 Credentials status code should be \"([^\"]*)\"$")
	public void invalid_OAUTH2_Credentials_status_code_should_be(String arg) {
		thrown.expect(HttpClientErrorException.class);
		thrown.expectMessage("401"); 
		HttpHeaders httpHeaders = getHttpHeaders(); 
		httpHeaders.add(TestConstants.AUTH.getValue(), TestConstants.BASIC.getValue()+getInvalidEncodedCredentials());
		HttpEntity<?> request = new HttpEntity<>(httpHeaders);
		try{
			REST_TEMPLATE.exchange(TestConstants.BASEURI.getValue()+TestConstants.VALID_USER_URL.getValue(), HttpMethod.POST, request, String.class);
		}catch(HttpClientErrorException e){
			
		}
	}
	
	@Given("^Valid OAUTH2 REST accesstoken$")
	public void valid_OAUTH2_REST_accesstoken() {
		logger.info("Test Valid OAUTH2 REST accesstoken");
	}
	
	
	@Then("^Valid OAUTH2 REST accesstoken should not null$")
	public void valid_OAUTH2_REST_accesstoken_should_not_null() throws JSONException {
		HttpHeaders httpHeaders = getHttpHeaders(); 
		httpHeaders.add(TestConstants.AUTH.getValue(), TestConstants.BASIC.getValue()+getEncodedCredentials());
		HttpEntity<?> request = new HttpEntity<>(httpHeaders);
		HttpEntity<String> response = REST_TEMPLATE.exchange(TestConstants.BASEURI.getValue()+TestConstants.VALID_USER_URL.getValue(), HttpMethod.POST, request, String.class);
		JSONObject jsonObj = new JSONObject(response.getBody()); 
		String accessToken = (String) jsonObj.get("access_token");
		assertNotNull(accessToken);
	}
	
	@Given("^Valid OAUTH2 REST GET PRODUCTS$")
	public void valid_OAUTH2_REST_GET_PRODUCTS() {
		logger.info("Test Valid OAUTH2 REST GET PRODUCTS");
	}
	
	
	@Then("^Valid OAUTH2 REST GET PRODUCTS should be success$")
	public void valid_OAUTH2_REST_GET_PRODUCTS_should_be_success() throws JSONException {
		HttpHeaders httpHeaders = getHttpHeaders(); 
		httpHeaders.add(TestConstants.AUTH.getValue(), TestConstants.BASIC.getValue()+getEncodedCredentials());
		HttpEntity<?> request = new HttpEntity<>(httpHeaders);
		HttpEntity<String> response = REST_TEMPLATE.exchange(TestConstants.BASEURI.getValue()+TestConstants.VALID_USER_URL.getValue(), HttpMethod.POST, request, String.class);
		JSONObject jsonObj = new JSONObject(response.getBody()); 
		String accessToken = (String) jsonObj.get("access_token");
		assertNotNull(accessToken);
		HttpHeaders reqHeaders = getHttpHeaders(); 
		reqHeaders.add(TestConstants.AUTH.getValue(), "Bearer "+accessToken);
		HttpEntity<?> httprequest = new HttpEntity<>(reqHeaders);
		HttpEntity<String> httpresponse = REST_TEMPLATE.exchange(TestConstants.BASEURI.getValue()+TestConstants.PRODUCTS.getValue(), HttpMethod.GET, httprequest, String.class);
		assertThat(httpresponse.getBody(), CoreMatchers.containsString("[{\"id\":1,\"name\":\"CLASSMATE\",\"category\":\"A\",\"cost\":35.0},{\"id\":2,\"name\":\"IPHONE\",\"category\":\"B\",\"cost\":35000.0},{\"id\":3,\"name\":\"SONY\",\"category\":\"C\",\"cost\":40000.0},{\"id\":4,\"name\":\"NON-CLASSMATE\",\"category\":\"A\",\"cost\":30.0}]"));
	}
	
	@Given("^Valid OAUTH2 REST service$")
	public void valid_OAUTH2_REST_service() {
		logger.info("Test Valid OAUTH2 REST service");
	}
	
	
	@Then("^Valid OAUTH2 REST service should be success$")
	public void valid_OAUTH2_REST_service_should_be_success() throws JSONException {
		HttpHeaders httpHeaders = getHttpHeaders(); 
		httpHeaders.add(TestConstants.AUTH.getValue(), TestConstants.BASIC.getValue()+getEncodedCredentials());
		HttpEntity<?> request = new HttpEntity<>(httpHeaders);
		HttpEntity<String> response = REST_TEMPLATE.exchange(TestConstants.BASEURI.getValue()+TestConstants.VALID_USER_URL.getValue(), HttpMethod.POST, request, String.class);
		JSONObject jsonObj = new JSONObject(response.getBody()); 
		String accessToken = (String) jsonObj.get("access_token");
		assertNotNull(accessToken);
		HttpHeaders reqHeaders = getHttpHeaders(); 
		reqHeaders.add(TestConstants.AUTH.getValue(), "Bearer "+accessToken);
		HttpEntity<?> httprequest = new HttpEntity<>(reqHeaders);
		HttpEntity<String> httpresponse = REST_TEMPLATE.exchange(TestConstants.BASEURI.getValue()+TestConstants.PRODUCTS.getValue(), HttpMethod.GET, httprequest, String.class);
		assertThat(httpresponse.getBody(), CoreMatchers.containsString("[{\"id\":1,\"name\":\"CLASSMATE\",\"category\":\"A\",\"cost\":35.0},{\"id\":2,\"name\":\"IPHONE\",\"category\":\"B\",\"cost\":35000.0},{\"id\":3,\"name\":\"SONY\",\"category\":\"C\",\"cost\":40000.0},{\"id\":4,\"name\":\"NON-CLASSMATE\",\"category\":\"A\",\"cost\":30.0}]"));
	}
	
	/**
	 * @return Encoded OAUTH2 Credentials.
	 */
	private String getEncodedCredentials() {
		String credentials = "my-trusted-client:secret";
		byte[] plainCredBytes = credentials.getBytes();
		byte[] base64CredBytes = Base64.encodeBase64(plainCredBytes);
		return new String(base64CredBytes);
	}
	
	/**
	 * @return Encoded OAUTH2 Invalid Credentials.
	 */
	private String getInvalidEncodedCredentials() {
		String credentials = "clientapp:123";
		byte[] plainCredBytes = credentials.getBytes();
		byte[] base64CredBytes = Base64.encodeBase64(plainCredBytes);
		return new String(base64CredBytes);
	}

}
