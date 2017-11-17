# ProductsApi

All URIs are relative to *https://localhost:8081*

Method | HTTP request | Description
------------- | ------------- | -------------
[**addProductUsingPOST**](ProductsApi.md#addProductUsingPOST) | **POST** /products | addProduct
[**deleteProductUsingDELETE**](ProductsApi.md#deleteProductUsingDELETE) | **DELETE** /products/{id} | deleteProduct
[**getProductsByTypeAndNameUsingGET**](ProductsApi.md#getProductsByTypeAndNameUsingGET) | **GET** /products/searchbyIds | getProductsByTypeAndName
[**getProductsUsingGET**](ProductsApi.md#getProductsUsingGET) | **GET** /products | getProducts


<a name="addProductUsingPOST"></a>
# **addProductUsingPOST**
> Void addProductUsingPOST(productVo)

addProduct

### Example
```java
// Import classes:
//import com.prokarma.pkmst.controller.ApiException;
//import com.prokarma.pkmst.controller.ProductsApi;


ProductsApi apiInstance = new ProductsApi();
ProductDto productVo = ; // ProductDto | productVo
try {
    Void result = apiInstance.addProductUsingPOST(productVo);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ProductsApi#addProductUsingPOST");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **productVo** | [**ProductDto**](ProductDto.md)| productVo |

### Return type

[**Void**](.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

<a name="deleteProductUsingDELETE"></a>
# **deleteProductUsingDELETE**
> Void deleteProductUsingDELETE(id)

deleteProduct

### Example
```java
// Import classes:
//import com.prokarma.pkmst.controller.ApiException;
//import com.prokarma.pkmst.controller.ProductsApi;


ProductsApi apiInstance = new ProductsApi();
Long id = 789; // Long | id
try {
    Void result = apiInstance.deleteProductUsingDELETE(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ProductsApi#deleteProductUsingDELETE");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| id |

### Return type

[**Void**](.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

<a name="getProductsByTypeAndNameUsingGET"></a>
# **getProductsByTypeAndNameUsingGET**
> ProductDto getProductsByTypeAndNameUsingGET(productIds)

getProductsByTypeAndName

### Example
```java
// Import classes:
//import com.prokarma.pkmst.controller.ApiException;
//import com.prokarma.pkmst.controller.ProductsApi;


ProductsApi apiInstance = new ProductsApi();
String productIds = productIds_example; // String | productIds
try {
    ProductDto result = apiInstance.getProductsByTypeAndNameUsingGET(productIds);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ProductsApi#getProductsByTypeAndNameUsingGET");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **productIds** | **String**| productIds |

### Return type

[**ProductDto**](ProductDto.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getProductsUsingGET"></a>
# **getProductsUsingGET**
> ProductDto getProductsUsingGET()

getProducts

### Example
```java
// Import classes:
//import com.prokarma.pkmst.controller.ApiException;
//import com.prokarma.pkmst.controller.ProductsApi;


ProductsApi apiInstance = new ProductsApi();
try {
    ProductDto result = apiInstance.getProductsUsingGET();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ProductsApi#getProductsUsingGET");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**ProductDto**](ProductDto.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

