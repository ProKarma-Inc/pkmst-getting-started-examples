# HelloApi

All URIs are relative to *http://localhost:8080*

Method | HTTP request | Description
------------- | ------------- | -------------
[**hello**](HelloApi.md#hello) | **GET** /hello | 


<a name="hello"></a>
# **hello**
> InlineResponse200 hello(name)



Returns &#39;Hello&#39; to the caller

### Example
```java
// Import classes:
//import com.prokarma.pkmst.controller.ApiException;
//import com.prokarma.pkmst.controller.HelloApi;


HelloApi apiInstance = new HelloApi();
String name = name_example; // String | The name of the person to whom to say hello
try {
    InlineResponse200 result = apiInstance.hello(name);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling HelloApi#hello");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **name** | **String**| The name of the person to whom to say hello | [optional]

### Return type

[**InlineResponse200**](InlineResponse200.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

