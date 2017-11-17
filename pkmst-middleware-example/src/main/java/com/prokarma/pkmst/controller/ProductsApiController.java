package com.prokarma.pkmst.controller;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import com.prokarma.pkmst.model.ProductDto;
import com.prokarma.pkmst.services.IProductService;

import io.swagger.annotations.ApiParam;
/**
 * Api implemention
 * @author pkmst
 *
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.PkmstServerCodegen", date = "2017-11-16T14:15:17.442Z")

@Controller
public class ProductsApiController implements ProductsApi {
	 private static final Logger LOG = Logger.getLogger(ProductsApiController.class.getName());
	   
	private final IProductService productService;

    public ProductsApiController(IProductService productService) {
        this.productService = productService;
    }


    public ResponseEntity<Void> addProductUsingPOST(@ApiParam(value = "productVo" ,required=true )   @RequestBody ProductDto productVo,
        @RequestHeader(value = "Accept", required = false) String accept) throws Exception {
    	LOG.log(Level.INFO, "Adding products");
        productService.addProduct(productVo);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    public ResponseEntity<Void> deleteProductUsingDELETE(@ApiParam(value = "id",required=true ) @PathVariable("id") Long id,
        @RequestHeader(value = "Accept", required = false) String accept) throws Exception {
    	LOG.log(Level.INFO, "Deleting product by ID");
        productService.deleteProduct(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    public ResponseEntity<List<ProductDto>> getProductsByTypeAndNameUsingGET(@ApiParam(value = "productIds", required = true)  @RequestParam(value = "productIds", required = true) String productIds,
        @RequestHeader(value = "Accept", required = false) String accept) throws Exception {
        // 

    	String[] stringIds = productIds.split(",");
        long[] ids = Arrays.stream(stringIds).mapToLong(Long::parseLong).toArray();
		LOG.log(Level.INFO, "Getting products by ID");
        

        return new ResponseEntity<List<ProductDto>>(productService.getProductsByIds(ids), HttpStatus.OK);
    }

    public ResponseEntity<List<ProductDto>> getProductsUsingGET(@RequestHeader(value = "Accept", required = false) String accept) throws Exception {
    	LOG.log(Level.INFO, "Getting all products");
        return new ResponseEntity<List<ProductDto>>(productService.getProducts(), HttpStatus.OK);
    }

}
