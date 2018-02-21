package com.prokarma.pkmst.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties("resourceEndPoints")
public class YmlConfig {

	private String stockServiceEndPoint;
	private String forexServiceEndPoint;

	public String getStockServiceEndPoint() {
		return stockServiceEndPoint;
	}

	public void setStockServiceEndPoint(String stockServiceEndPoint) {
		this.stockServiceEndPoint = stockServiceEndPoint;
	}

	public String getForexServiceEndPoint() {
		return forexServiceEndPoint;
	}

	public void setForexServiceEndPoint(String forexServiceEndPoint) {
		this.forexServiceEndPoint = forexServiceEndPoint;
	}

}
