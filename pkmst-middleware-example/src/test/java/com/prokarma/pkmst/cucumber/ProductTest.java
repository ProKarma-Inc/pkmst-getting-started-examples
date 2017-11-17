package com.prokarma.pkmst.cucumber;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)

@CucumberOptions(format = { "pretty", "html:target/cucumber-html-report","json:./report/product-report-json/product.json" })
public class ProductTest {
}