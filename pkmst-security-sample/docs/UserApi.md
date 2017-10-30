# UserApi

All URIs are relative to *http://petstore.swagger.io/v2*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createUser**](UserApi.md#createUser) | **POST** /user | Create user
[**createUsersWithArrayInput**](UserApi.md#createUsersWithArrayInput) | **POST** /user/createWithArray | Creates list of users with given input array
[**createUsersWithListInput**](UserApi.md#createUsersWithListInput) | **POST** /user/createWithList | Creates list of users with given input array
[**deleteUser**](UserApi.md#deleteUser) | **DELETE** /user/{username} | Delete user
[**getUserByName**](UserApi.md#getUserByName) | **GET** /user/{username} | Get user by user name
[**loginUser**](UserApi.md#loginUser) | **GET** /user/login | Logs user into the system
[**logoutUser**](UserApi.md#logoutUser) | **GET** /user/logout | Logs out current logged in user session
[**updateUser**](UserApi.md#updateUser) | **PUT** /user/{username} | Updated user


<a name="createUser"></a>
# **createUser**
> String createUser(body)

Create user

This can only be done by the logged in user.

### Example
```java
// Import classes:
//import com.prokarma.pkmst.controller.ApiClient;
//import com.prokarma.pkmst.controller.ApiException;
//import com.prokarma.pkmst.controller.Configuration;
//import com.prokarma.pkmst.controller.auth.*;
//import com.prokarma.pkmst.controller.UserApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure OAuth2 access token for authorization: user_auth
OAuth user_auth = (OAuth) defaultClient.getAuthentication("user_auth");
user_auth.setAccessToken("YOUR ACCESS TOKEN");

UserApi apiInstance = new UserApi();
User body = ; // User | Created user object
try {
    String result = apiInstance.createUser(body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UserApi#createUser");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**User**](User.md)| Created user object |

### Return type

**String**

### Authorization

[user_auth](../README.md#user_auth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="createUsersWithArrayInput"></a>
# **createUsersWithArrayInput**
> String createUsersWithArrayInput(body)

Creates list of users with given input array



### Example
```java
// Import classes:
//import com.prokarma.pkmst.controller.ApiClient;
//import com.prokarma.pkmst.controller.ApiException;
//import com.prokarma.pkmst.controller.Configuration;
//import com.prokarma.pkmst.controller.auth.*;
//import com.prokarma.pkmst.controller.UserApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure OAuth2 access token for authorization: user_auth
OAuth user_auth = (OAuth) defaultClient.getAuthentication("user_auth");
user_auth.setAccessToken("YOUR ACCESS TOKEN");

UserApi apiInstance = new UserApi();
List<User> body = ; // List<User> | List of user object
try {
    String result = apiInstance.createUsersWithArrayInput(body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UserApi#createUsersWithArrayInput");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**List&lt;User&gt;**](User.md)| List of user object |

### Return type

**String**

### Authorization

[user_auth](../README.md#user_auth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="createUsersWithListInput"></a>
# **createUsersWithListInput**
> String createUsersWithListInput(body)

Creates list of users with given input array



### Example
```java
// Import classes:
//import com.prokarma.pkmst.controller.ApiClient;
//import com.prokarma.pkmst.controller.ApiException;
//import com.prokarma.pkmst.controller.Configuration;
//import com.prokarma.pkmst.controller.auth.*;
//import com.prokarma.pkmst.controller.UserApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure OAuth2 access token for authorization: user_auth
OAuth user_auth = (OAuth) defaultClient.getAuthentication("user_auth");
user_auth.setAccessToken("YOUR ACCESS TOKEN");

UserApi apiInstance = new UserApi();
List<User> body = ; // List<User> | List of user object
try {
    String result = apiInstance.createUsersWithListInput(body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UserApi#createUsersWithListInput");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**List&lt;User&gt;**](User.md)| List of user object |

### Return type

**String**

### Authorization

[user_auth](../README.md#user_auth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="deleteUser"></a>
# **deleteUser**
> String deleteUser(username)

Delete user

This can only be done by the logged in user.

### Example
```java
// Import classes:
//import com.prokarma.pkmst.controller.ApiClient;
//import com.prokarma.pkmst.controller.ApiException;
//import com.prokarma.pkmst.controller.Configuration;
//import com.prokarma.pkmst.controller.auth.*;
//import com.prokarma.pkmst.controller.UserApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure OAuth2 access token for authorization: user_auth
OAuth user_auth = (OAuth) defaultClient.getAuthentication("user_auth");
user_auth.setAccessToken("YOUR ACCESS TOKEN");

UserApi apiInstance = new UserApi();
String username = username_example; // String | The name that needs to be deleted
try {
    String result = apiInstance.deleteUser(username);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UserApi#deleteUser");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **username** | **String**| The name that needs to be deleted |

### Return type

**String**

### Authorization

[user_auth](../README.md#user_auth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getUserByName"></a>
# **getUserByName**
> User getUserByName(username)

Get user by user name



### Example
```java
// Import classes:
//import com.prokarma.pkmst.controller.ApiException;
//import com.prokarma.pkmst.controller.UserApi;


UserApi apiInstance = new UserApi();
String username = username_example; // String | The name that needs to be fetched. Use user for testing. 
try {
    User result = apiInstance.getUserByName(username);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UserApi#getUserByName");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **username** | **String**| The name that needs to be fetched. Use user for testing.  |

### Return type

[**User**](User.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="loginUser"></a>
# **loginUser**
> String loginUser(username, password)

Logs user into the system



### Example
```java
// Import classes:
//import com.prokarma.pkmst.controller.ApiException;
//import com.prokarma.pkmst.controller.UserApi;


UserApi apiInstance = new UserApi();
String username = username_example; // String | The user name for login
String password = password_example; // String | The password for login in clear text
try {
    String result = apiInstance.loginUser(username, password);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UserApi#loginUser");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **username** | **String**| The user name for login |
 **password** | **String**| The password for login in clear text |

### Return type

**String**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/xml, application/json

<a name="logoutUser"></a>
# **logoutUser**
> String logoutUser()

Logs out current logged in user session



### Example
```java
// Import classes:
//import com.prokarma.pkmst.controller.ApiException;
//import com.prokarma.pkmst.controller.UserApi;


UserApi apiInstance = new UserApi();
try {
    String result = apiInstance.logoutUser();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UserApi#logoutUser");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

**String**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="updateUser"></a>
# **updateUser**
> String updateUser(username, body)

Updated user

This can only be done by the logged in user.

### Example
```java
// Import classes:
//import com.prokarma.pkmst.controller.ApiClient;
//import com.prokarma.pkmst.controller.ApiException;
//import com.prokarma.pkmst.controller.Configuration;
//import com.prokarma.pkmst.controller.auth.*;
//import com.prokarma.pkmst.controller.UserApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure OAuth2 access token for authorization: user_auth
OAuth user_auth = (OAuth) defaultClient.getAuthentication("user_auth");
user_auth.setAccessToken("YOUR ACCESS TOKEN");

UserApi apiInstance = new UserApi();
String username = username_example; // String | name that need to be updated
User body = ; // User | Updated user object
try {
    String result = apiInstance.updateUser(username, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UserApi#updateUser");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **username** | **String**| name that need to be updated |
 **body** | [**User**](User.md)| Updated user object |

### Return type

**String**

### Authorization

[user_auth](../README.md#user_auth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

