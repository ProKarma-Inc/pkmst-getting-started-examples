package com.prokarma.pkmst.pkmst.config;

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

	// JWT related constants
	public static final String SECRET = "SecretKeyToGenJWTs";

	public static final long EXPIRATION_TIME = 864_000_000; // 10 days

	public static final String TOKEN_PREFIX = "Bearer ";

	public static final String HEADER_STRING = "Authorization";

	public static final String SIGN_UP_URL = "/user/sign-up";

}
