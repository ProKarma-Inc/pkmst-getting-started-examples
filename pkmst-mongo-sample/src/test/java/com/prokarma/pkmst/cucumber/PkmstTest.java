package com.prokarma.pkmst.cucumber;

import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@ActiveProfiles("test")
@CucumberOptions(format = { "pretty", "html:target/cucumber-html-report",
 "json:./report/car-report-json/car.json",
 })
@Ignore
public class PkmstTest {
}