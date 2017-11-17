package com.prokarma.pkmst.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import com.prokarma.pkmst.controller.ProductsApiController;
import com.prokarma.pkmst.dao.IProductDao;
import com.prokarma.pkmst.dao.impl.ProductDaoImpl;
import com.prokarma.pkmst.services.IProductService;
import com.prokarma.pkmst.services.impl.ProductServiceImpl;



/**
 * @author pkmst
 *
 */
@Configuration
public class ApplicationConfig {

    @Bean
    public ProductsApiController productsApiController(final IProductService productService) {
        return new ProductsApiController(productService);
    }

    @Bean
    public IProductService productService(final IProductDao iProductDao) {
        return new ProductServiceImpl(iProductDao);
    }

    @Bean
    public IProductDao productDao(final JdbcTemplate jdbcTemplate) {
        return new ProductDaoImpl(jdbcTemplate);
    }

    @Bean
    public JdbcTemplate jdbcTemplate(final DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean
    public DataSource dataSource() {
        EmbeddedDatabaseBuilder embeddedDatabaseBuilder = new EmbeddedDatabaseBuilder();
        EmbeddedDatabase embeddedDatabase = embeddedDatabaseBuilder.setType(EmbeddedDatabaseType.H2).
        		addScript("drop-db.sql").addScript("create-db.sql").addScript("insert-data.sql").build();
        return embeddedDatabase;
    }
}
