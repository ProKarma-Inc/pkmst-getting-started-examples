package com.prokarma.product.pkmst.services;

import java.util.List;

import com.prokarma.product.pkmst.dto.ProductDto;


/**
 * @author Ninod Pillai
 *
 */
public interface IProductService {

    void addProduct(ProductDto productVo);

    List<ProductDto> getProducts();

    void deleteProduct(Long id);

    List<ProductDto> getProductsByIds(long[] productIds);
}
