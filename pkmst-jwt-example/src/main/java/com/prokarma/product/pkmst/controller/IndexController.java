package com.prokarma.product.pkmst.controller;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Ninod Pillai
 *
 */
@RestController
public class IndexController implements ErrorController{
    private static final Logger LOG = Logger.getLogger(IndexController.class.getName());
    private static final String PATH = "/error";

    /**
     * @return
     */
    @RequestMapping(value = PATH)
    public String error() {
	LOG.log(Level.INFO, "Passed URL path Not configured for product service, Please use http://domain/products");
        return "Passed URL path Not configured for product service, Please use http://domain/products";
    }

    @Override
    public String getErrorPath() {
	   LOG.log(Level.INFO, "Returning Path");
        return PATH;
    }
}