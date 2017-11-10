package com.prokarma.pkmst.controller;

import java.util.logging.Logger;

import org.junit.Assert;
import org.junit.Test;

public class HelloWorldControllerTests {
	private final HelloWorldApi helloWorldApiController = new HelloWorldApiController();

	@Test
	public void validateHelloGreeting() {
		Logger.getGlobal().info("Start validateHelloGreeting test");
		String greetHello = helloWorldApiController.greetHello("test1");

		Assert.assertEquals("Hello! welcome  test1", greetHello);
		Logger.getGlobal().info("End validateHelloGreeting test");
	}

	@Test
	public void validatesayHelloGreeting() {
		Logger.getGlobal().info("Start validatesayHelloGreeting test");
		String greetHello = helloWorldApiController.sayHello("testPROK");

		Assert.assertEquals("Hello! welcome  testPROK", greetHello);
		Logger.getGlobal().info("End validatesayHelloGreeting test");
	}
}
