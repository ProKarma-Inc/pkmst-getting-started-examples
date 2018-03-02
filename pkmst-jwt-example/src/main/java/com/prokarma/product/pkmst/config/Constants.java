package com.prokarma.product.pkmst.config;

public final class Constants {

	private Constants() {
	}

	// Spring profile for development and production
	public static final String SPRING_PROFILE_DEVELOPMENT = "dev";
	public static final String SPRING_PROFILE_PRODUCTION = "prod";
	// Spring profile used when deploying with Spring Cloud (used when deploying
	// to CloudFoundry)
	public static final String SPRING_PROFILE_CLOUD = "cloud";
	// Spring profile used to disable swagger
	public static final String SPRING_PROFILE_SWAGGER = "swagger";
	
	public static final String QUOTE_URL = "http://api.icndb.com/jokes/random";

}
