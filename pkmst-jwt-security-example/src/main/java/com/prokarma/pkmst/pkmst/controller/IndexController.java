package com.prokarma.pkmst.pkmst.controller;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Ninod Pillai
 *
 */
@RestController
public class IndexController implements ErrorController {
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

	/**
	 * @return
	 */
	@RequestMapping(value = "/accessDenied")
	public String accessDenied() {
		LOG.log(Level.INFO, "Passed URL path Not configured for product service, Please use http://domain/products");
		return "Invalid User Id/Password. Please sign up if you are new user http://domain/user/sign-up";
	}

	@Override
	public String getErrorPath() {
		LOG.log(Level.INFO, "Returning Path");
		return PATH;
	}
}