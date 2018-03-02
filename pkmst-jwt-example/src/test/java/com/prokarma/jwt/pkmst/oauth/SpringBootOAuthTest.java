package com.prokarma.jwt.pkmst.oauth;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import org.apache.commons.codec.binary.Base64;
import org.hamcrest.CoreMatchers;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.security.oauth2.client.DefaultOAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.token.grant.password.ResourceOwnerPasswordResourceDetails;
import org.springframework.web.client.HttpClientErrorException;

import com.prokarma.product.pkmst.dto.ProductDto;

/**
 * @author prokarma
 *
 */

public class SpringBootOAuthTest extends BaseTest{

	/**
	 * Test Unauthorized access for REST Service.
	 */
	@Test
	public void testRestServiceUnauthorized() {
		thrown.expect(HttpClientErrorException.class);
		thrown.expectMessage("401"); 
		
		HttpEntity<?> request = new HttpEntity<>(getHttpHeaders());
		REST_TEMPLATE.exchange(TestConstants.BASEURI.getValue()+TestConstants.PRODUCTS.getValue(), HttpMethod.GET, request, String.class);
	}
	
	/**
	 * Test Invalid User Credentials 
	 */
	@Test
	public void testOAuthInvalidUserSecret() {
		thrown.expect(HttpClientErrorException.class);
		thrown.expectMessage("400"); 
		HttpHeaders httpHeaders = getHttpHeaders(); 
		httpHeaders.add(TestConstants.AUTH.getValue(), TestConstants.BASIC.getValue()+getEncodedCredentials());
		HttpEntity<?> request = new HttpEntity<>(httpHeaders);
		REST_TEMPLATE.exchange(TestConstants.BASEURI.getValue()+TestConstants.INVALID_USER_URL.getValue(), HttpMethod.POST, request, String.class);
	}

	/**
	 * Test Invalid OAUTH2 Credentials 
	 */
	@Test
	public void testInvalidOAuthSecret() {
		thrown.expect(HttpClientErrorException.class);
		thrown.expectMessage("401"); 
		HttpHeaders httpHeaders = getHttpHeaders(); 
		httpHeaders.add(TestConstants.AUTH.getValue(), TestConstants.BASIC.getValue()+getInvalidEncodedCredentials());
		HttpEntity<?> request = new HttpEntity<>(httpHeaders);
		REST_TEMPLATE.exchange(TestConstants.BASEURI.getValue()+TestConstants.VALID_USER_URL.getValue(), HttpMethod.POST, request, String.class);
	}
	
	/**
	 * Test Valid OAUTH2 REST accesstoken 
	 * @throws JSONException 
	 */
	@Test
	public void testOAuth2AccessToken() throws JSONException {
		HttpHeaders httpHeaders = getHttpHeaders(); 
		httpHeaders.add(TestConstants.AUTH.getValue(), TestConstants.BASIC.getValue()+getEncodedCredentials());
		HttpEntity<?> request = new HttpEntity<>(httpHeaders);
		HttpEntity<String> response = REST_TEMPLATE.exchange(TestConstants.BASEURI.getValue()+TestConstants.VALID_USER_URL.getValue(), HttpMethod.POST, request, String.class);
		JSONObject jsonObj = new JSONObject(response.getBody()); 
		String accessToken = (String) jsonObj.get("access_token");
		assertNotNull(accessToken);
	}
	
	/**
	 * Test Valid OAUTH2 REST  //GET PRODUCTS
	 * @throws JSONException 
	 */
	@Test
	public void testOAuth2RestService() throws JSONException {
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
	 * Test Valid OAUTH2 REST service 
	 */
	@Test
	public void testOAuth2Service() {
		ResourceOwnerPasswordResourceDetails resourceDetails = new ResourceOwnerPasswordResourceDetails();
		resourceDetails.setUsername("anshu");
	    resourceDetails.setPassword("abc123");
	    resourceDetails.setAccessTokenUri("http://localhost:8081/oauth/token");
        resourceDetails.setClientId("my-trusted-client");
        resourceDetails.setClientSecret("secret");
        resourceDetails.setGrantType("password");
        resourceDetails.setScope(asList("read", "write","trust"));
        
        DefaultOAuth2ClientContext clientContext = new DefaultOAuth2ClientContext();
        OAuth2RestTemplate restTemplate = new OAuth2RestTemplate(resourceDetails, clientContext);
        restTemplate.setMessageConverters(asList(new MappingJackson2HttpMessageConverter()));
        assertNotNull(restTemplate.getAccessToken());
		ProductDto[] productDto = restTemplate.getForObject(TestConstants.BASEURI.getValue()+TestConstants.PRODUCTS.getValue(), ProductDto[].class);
        assertThat(productDto[0].getName(),CoreMatchers.containsString("CLASSMATE"));
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
