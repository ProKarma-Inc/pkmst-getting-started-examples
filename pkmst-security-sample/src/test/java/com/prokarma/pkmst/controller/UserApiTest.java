

package com.prokarma.pkmst.controller;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Iterator;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.prokarma.pkmst.model.User;
import com.prokarma.pkmst.model.UserRepository;
import com.prokarma.pkmst.service.UserDetailServiceImpl;

/**
 * API tests for UserApi
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class UserApiTest {

    private final ObjectMapper objectMapper = new ObjectMapper();
    
    @InjectMocks    
    private UserApiController api;
    
    private UserDetailServiceImpl userDetailsService;
    
    private UserRepository repository;
    
    
    private String userName ="user";
    
    private String password = "user";

    private final String accept = "application/json";
    
    @Before
    public void setUp() {
    	userDetailsService = mock(UserDetailServiceImpl.class);
    	repository = mock(UserRepository.class);
        MockitoAnnotations.initMocks(this);
        UserDetails userDetails = mock(UserDetails.class);
        when(userDetailsService.loadUserByUsernamePassword(userName, password)).thenReturn(userDetails);
    }
   
    @Test
    public void createUserTest() throws Exception {
    	User body = mock(User.class);
    	
    	api.loginUser(userName, password, accept);
    	
    	verify(userDetailsService).loadUserByUsernamePassword(userName, password);
    	api.createUser(body , accept);
    	verify(repository).save(any(User.class));
    	
    }
    
    /**
     * Creates list of users with given input array
     *
     * 
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void createUsersWithArrayInputTest() throws Exception {
    	User user1 = mock(User.class);
        Iterator<User> itr = mock(Iterator.class);
        when(itr.next()).thenReturn(user1);
        when(itr.hasNext()).thenReturn(true, false);
          

        List<User> mockNameList = Mockito.mock(List.class);
        when(mockNameList.iterator()).thenReturn(itr);
        
    	api.loginUser(userName, password, accept);
    	
    	verify(userDetailsService).loadUserByUsernamePassword(userName, password);
    	api.createUsersWithArrayInput(mockNameList , accept);
    	verify(repository).save(any(User.class));

    }
    
    /**
     * Creates list of users with given input array
     *
     * 
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void createUsersWithListInputTest() throws Exception {
    	User user1 = mock(User.class);
        Iterator<User> itr = mock(Iterator.class);
        when(itr.next()).thenReturn(user1);
        when(itr.hasNext()).thenReturn(true, false);
        List<User> body = Mockito.mock(List.class);
        when(body.iterator()).thenReturn(itr);
    	api.loginUser(userName, password, accept);
    	
    	verify(userDetailsService).loadUserByUsernamePassword(userName, password);
    	api.createUsersWithListInput(body , accept);
    	verify(repository).save(any(User.class));
    }
    
    /**
     * Delete user
     *
     * This can only be done by the logged in user.
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void deleteUserTest() throws Exception {
    	User user1 = mock(User.class);
    	when(user1.getId()).thenReturn(1L);
    	when(repository.findByUsername(userName)).thenReturn(user1);
    	
    	api.loginUser(userName, password, accept);
    	
    	verify(userDetailsService).loadUserByUsernamePassword(userName, password);
    	api.deleteUser(userName , accept);
    	verify(repository).delete(any(Long.class));
    	

        // TODO: test validations
    }
    
    /**
     * Get user by user name
     *
     * 
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void getUserByNameTest() throws Exception {
        String username = null;
//        ResponseEntity<User> response = api.getUserByName(username , accept);
        
        User user1 = mock(User.class);
    	when(user1.getId()).thenReturn(1L);
    	when(repository.findByUsername(userName)).thenReturn(user1);
    	
    	api.loginUser(userName, password, accept);
    	
    	verify(userDetailsService).loadUserByUsernamePassword(userName, password);
    	api.getUserByName(userName , accept);
    	verify(repository).findByUsername(any(String.class));

    }
    
    /**
     * Logs user into the system
     *
     * 
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void loginUserTest() throws Exception {
	    api.loginUser(userName, password, accept);
	    verify(userDetailsService).loadUserByUsernamePassword(userName, password);
    }
    
    /**
     * Logs out current logged in user session
     *
     * 
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void logoutUserTest() throws Exception {
    	Assert.assertNotNull(api.logoutUser(accept));
    }
    
    /**
     * Updated user
     *
     * This can only be done by the logged in user.
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void updateUserTest() throws Exception {
    	User body = mock(User.class);
    	
    	api.loginUser(userName, password, accept);
    	
    	verify(userDetailsService).loadUserByUsernamePassword(userName, password);
    	api.updateUser(userName, body , accept);
    	verify(repository).save(any(User.class));    	 
    }
    
}
