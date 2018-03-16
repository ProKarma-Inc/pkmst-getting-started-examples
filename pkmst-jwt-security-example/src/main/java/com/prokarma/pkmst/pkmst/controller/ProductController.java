package com.prokarma.pkmst.pkmst.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import com.prokarma.pkmst.pkmst.dto.ProductDto;
import com.prokarma.pkmst.pkmst.services.IProductService;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * @author Ninod Pillai
 *
 */
@RestController
@RequestMapping(value = "products")
public class ProductController {
    private static final Logger LOG = Logger.getLogger(ProductController.class.getName());
    private final IProductService productService;

    public ProductController(IProductService productService) {
        this.productService = productService;
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addProduct(@RequestBody final ProductDto productVo) {
	LOG.log(Level.INFO, "Adding products");
        productService.addProduct(productVo);
    }

    @RequestMapping(value = "/searchbyIds", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ProductDto> getProductsByTypeAndName(@RequestParam(value = "productIds", required = true) final String productIds) {
        String[] stringIds = productIds.split(",");
        long[] ids = Arrays.stream(stringIds).mapToLong(Long::parseLong).toArray();
		LOG.log(Level.INFO, "Getting products by ID");
        return productService.getProductsByIds(ids);
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ProductDto> getProducts() {
	LOG.log(Level.INFO, "Getting all products");
        return productService.getProducts();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteProduct(@PathVariable final Long id) {
	LOG.log(Level.INFO, "Deleting product by ID");
        productService.deleteProduct(id);
    }
}
