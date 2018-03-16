package com.prokarma.pkmst.pkmst.services.impl;

import com.google.common.primitives.Longs;
import com.prokarma.pkmst.pkmst.dao.IProductDao;
import com.prokarma.pkmst.pkmst.dto.ProductDto;
import com.prokarma.pkmst.pkmst.services.IProductService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import java.util.List;
import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * @author Ninod Pillai
 *
 */
public class ProductServiceImpl implements IProductService {

    private final IProductDao productDao;

    public ProductServiceImpl(IProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public void addProduct(ProductDto productVo) {
        productDao.save(productVo);
    }

    @Override
    @HystrixCommand (fallbackMethod = "fallbackGetProductService")
    public List<ProductDto> getProducts() {
        return productDao.findAll();
    }

    @Override
    public void deleteProduct(Long id) {
        productDao.delete(id);
    }

    @Override
    public List<ProductDto> getProductsByIds(long[] productIds) {
        return productDao.getProductsByIds(Longs.asList(productIds));
    }
    
    private List<ProductDto> fallbackGetProductService(){
    	
    	List<ProductDto> productDtoList= new ArrayList<ProductDto>();
    	ProductDto productDto = new ProductDto();
    	productDto.setId(123L);
    	productDto.setName("Iphone");
    	productDto.setCategory("Mobile");
    	productDto.setCost(new BigDecimal(799.99));
    	productDtoList.add(productDto);
    	return productDtoList;
    }
}
