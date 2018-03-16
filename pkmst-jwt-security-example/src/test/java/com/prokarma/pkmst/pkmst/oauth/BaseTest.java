package com.prokarma.pkmst.pkmst.oauth;


import org.junit.Rule;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationContextLoader;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.http.HttpHeaders;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.context.ContextConfiguration;
import com.prokarma.pkmst.pkmst.ProductServiceApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=ProductServiceApplication.class, loader = SpringApplicationContextLoader.class)
@WebAppConfiguration
@IntegrationTest
//@DirtiesContext(classMode=ClassMode.AFTER_CLASS)
public abstract class BaseTest {
	
	public enum TestConstants {
		AUTH ("Authorization"),
		BASEURI("http://localhost:8081/"),
		BASIC("Basic "),
		PRODUCTS("products"),
		PRODUCTBYID("products/searchbyIds?productIds=2"),
		INVALID_USER_URL("oauth/token?grant_type=password&username=anshu&password=Hello"),
		VALID_USER_URL("oauth/token?grant_type=password&username=anshu&password=abc123"),
		OAUTH_USER_URL("http://localhost:8081/products?access_token=");
		
		 private String value;

		 TestConstants(String stringVal) {
		     this.value = stringVal;
		  }

		  public String getValue() {
		      return value;
		  }
	};
	public static final RestTemplate REST_TEMPLATE = new RestTemplate();
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	/**
	 * @return Base HttpHeaders 
	 */
	public HttpHeaders getHttpHeaders() {
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("Accept", "application/json");
		return httpHeaders;
	}

}
