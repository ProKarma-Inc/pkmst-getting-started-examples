# CarApi

All URIs are relative to *http://petstore.swagger.io/v2*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createCar**](CarApi.md#createCar) | **POST** /car | Create Car
[**createCarsWithArrayInput**](CarApi.md#createCarsWithArrayInput) | **POST** /car/createWithArray | Creates list of cars with given input array
[**deleteCar**](CarApi.md#deleteCar) | **DELETE** /car/{vinNumber} | Delete car
[**getCarByVinNumber**](CarApi.md#getCarByVinNumber) | **GET** /car/{vinNumber} | Get car by vin number
[**updateCar**](CarApi.md#updateCar) | **PUT** /car/{vinNumber} | Updated car


<a name="createCar"></a>
# **createCar**
> Void createCar(body)

Create Car



### Example
```java
// Import classes:
//import com.prokarma.pkmst.controller.ApiException;
//import com.prokarma.pkmst.controller.CarApi;


CarApi apiInstance = new CarApi();
Car body = ; // Car | Created car object
try {
    Void result = apiInstance.createCar(body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling CarApi#createCar");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**Car**](Car.md)| Created car object |

### Return type

[**Void**](.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/xml, application/json

<a name="createCarsWithArrayInput"></a>
# **createCarsWithArrayInput**
> Void createCarsWithArrayInput(body)

Creates list of cars with given input array



### Example
```java
// Import classes:
//import com.prokarma.pkmst.controller.ApiException;
//import com.prokarma.pkmst.controller.CarApi;


CarApi apiInstance = new CarApi();
List<Car> body = ; // List<Car> | List of car object
try {
    Void result = apiInstance.createCarsWithArrayInput(body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling CarApi#createCarsWithArrayInput");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**List&lt;Car&gt;**](Car.md)| List of car object |

### Return type

[**Void**](.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/xml, application/json

<a name="deleteCar"></a>
# **deleteCar**
> Void deleteCar(vinNumber)

Delete car



### Example
```java
// Import classes:
//import com.prokarma.pkmst.controller.ApiException;
//import com.prokarma.pkmst.controller.CarApi;


CarApi apiInstance = new CarApi();
String vinNumber = vinNumber_example; // String | The car vinNumber that needs to be deleted
try {
    Void result = apiInstance.deleteCar(vinNumber);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling CarApi#deleteCar");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **vinNumber** | **String**| The car vinNumber that needs to be deleted |

### Return type

[**Void**](.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/xml, application/json

<a name="getCarByVinNumber"></a>
# **getCarByVinNumber**
> Car getCarByVinNumber(vinNumber)

Get car by vin number



### Example
```java
// Import classes:
//import com.prokarma.pkmst.controller.ApiException;
//import com.prokarma.pkmst.controller.CarApi;


CarApi apiInstance = new CarApi();
String vinNumber = vinNumber_example; // String | The vinNumber that needs to be fetched. Use v101 for testing. 
try {
    Car result = apiInstance.getCarByVinNumber(vinNumber);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling CarApi#getCarByVinNumber");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **vinNumber** | **String**| The vinNumber that needs to be fetched. Use v101 for testing.  |

### Return type

[**Car**](Car.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/xml, application/json

<a name="updateCar"></a>
# **updateCar**
> Void updateCar(vinNumber, body)

Updated car



### Example
```java
// Import classes:
//import com.prokarma.pkmst.controller.ApiException;
//import com.prokarma.pkmst.controller.CarApi;


CarApi apiInstance = new CarApi();
String vinNumber = vinNumber_example; // String | vinNumber that need to be updated
Car body = ; // Car | Updated car object
try {
    Void result = apiInstance.updateCar(vinNumber, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling CarApi#updateCar");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **vinNumber** | **String**| vinNumber that need to be updated |
 **body** | [**Car**](Car.md)| Updated car object |

### Return type

[**Void**](.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/xml, application/json

