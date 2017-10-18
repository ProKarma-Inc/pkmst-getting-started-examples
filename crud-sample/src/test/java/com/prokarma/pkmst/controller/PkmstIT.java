package com.prokarma.pkmst.controller;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import com.prokarma.pkmst.PkmstApplication;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = PkmstApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PkmstIT {

	@LocalServerPort
	private int port;

	TestRestTemplate restTemplate = new TestRestTemplate();

	HttpHeaders headers = new HttpHeaders();

	@Test
	public void testRetrieveStudentCourse() {

		//add your logic
	}

	private String createURLWithPort(String uri) {
		return "http://localhost:" + port + uri;
	}
	 @Test
        public void createUserTest() throws Exception {
        User body = null;
    ResponseEntity<Void> response = api.createUser(body , accept);
          }
    
    @Test
    public void createUsersWithArrayInputTest() throws Exception {
        List<User> body = null;
    ResponseEntity<Void> response = api.createUsersWithArrayInput(body , accept);

    }
    
    @Test
    public void createUsersWithListInputTest() throws Exception {
        List<User> body = null;
    ResponseEntity<Void> response = api.createUsersWithListInput(body , accept);
    }
    
    @Test
    public void deleteUserTest() throws Exception {
        String username = null;
    ResponseEntity<Void> response = api.deleteUser(username , accept);
     }
    
    @Test
    public void getUserByNameTest() throws Exception {
        String username = null;
    ResponseEntity<User> response = api.getUserByName(username , accept);
    }
    
    @Test
    public void loginUserTest() throws Exception {
        String username = null;
        String password = null;
    ResponseEntity<String> response = api.loginUser(username, password , accept);

    }
   
    @Test
    public void logoutUserTest() throws Exception {
    ResponseEntity<Void> response = api.logoutUser(  accept);

    }
    @Test
    public void updateUserTest() throws Exception {
        String username = null;
        User body = null;
    ResponseEntity<Void> response = api.updateUser(username, body , accept);

    }
}
