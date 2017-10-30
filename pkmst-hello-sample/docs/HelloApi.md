# HelloApi

All URIs are relative to *http://petstore.swagger.io/v2*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getEmployeeByEmpNumber**](HelloApi.md#getEmployeeByEmpNumber) | **GET** /hello/{greetMessage} | Get employee by emp number


<a name="getEmployeeByEmpNumber"></a>
# **getEmployeeByEmpNumber**
> String getEmployeeByEmpNumber(greetMessage)

Get employee by emp number



### Example
```java
// Import classes:
//import com.prokarma.pkmst.controller.ApiException;
//import com.prokarma.pkmst.controller.HelloApi;


HelloApi apiInstance = new HelloApi();
String greetMessage = greetMessage_example; // String | Greet message
try {
    String result = apiInstance.getEmployeeByEmpNumber(greetMessage);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling HelloApi#getEmployeeByEmpNumber");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **greetMessage** | **String**| Greet message |

### Return type

**String**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

