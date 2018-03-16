/**
 * 
 */
package com.prokarma.pkmst.pkmst.jwt;

import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.HttpClientErrorException;

/**
 * @author prokarma
 *
 */
public class SpringBootJwtTest extends JwtBaseTest {

	/**
	 * Test Unauthorized access for REST Service.
	 */
	@Test
	public void testRestServiceUnauthorized() {
		thrown.expect(HttpClientErrorException.class);
		thrown.expectMessage("403");

		HttpEntity<?> request = new HttpEntity<>(getHttpHeaders());
		REST_TEMPLATE.exchange(TestConstants.BASEURI.getValue() + TestConstants.PRODUCTS.getValue(), HttpMethod.GET,
				request, String.class);
	}

	/**
	 * Test Invalid User Credentials
	 */
	@Test
	public void testInvalidLoginUser() {
		thrown.expect(HttpClientErrorException.class);
		thrown.expectMessage("400");
		HttpHeaders httpHeaders = getHttpHeaders();
		httpHeaders.add(TestConstants.AUTH.getValue(),
				"Bearer eyJhbGciOiJIUzUxMiJ9.eyzdWIiOINVALIDiIsImV4cCI6MTUyMTUwNTgxMH0.NlwZg-hxiRWrHnOj5WyORuAQ1mm2N9BU6zpWyiLs96ynUeUEbguL1PCvzU8RvZnlfOx9gjAGKn7hTIB8wyDh8A");
		HttpEntity<?> request = new HttpEntity<>(httpHeaders);
		REST_TEMPLATE.exchange(TestConstants.BASEURI.getValue() + TestConstants.LOGIN.getValue(), HttpMethod.POST,
				request, String.class);
	}

}
