package com.prokarma.pkmst.config;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.broker.BrokerService;
import org.apache.commons.lang.exception.NestableRuntimeException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.connection.CachingConnectionFactory;
import org.springframework.jms.core.JmsTemplate;

@Configuration
@EnableJms
public class JmsConfig {
	
	@Value("${activemq.brokerUrl}")
	private String brokerUrl;

	@Bean
	  public ActiveMQConnectionFactory activeMQConnectionFactory() {
		if(StringUtils.contains(this.brokerUrl, "localhost")) {
			configureEmbeddedBroker();
		}

	    ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory();
	    activeMQConnectionFactory.setBrokerURL(this.brokerUrl);
	    return activeMQConnectionFactory;
	  }

	private void configureEmbeddedBroker() {
		try {
			BrokerService broker = new BrokerService();			
			broker.addConnector(this.brokerUrl);
			broker.setPersistent(false);
			broker.start();			
		} catch (Exception e) {
			throw new NestableRuntimeException("Failed to configure an embedded broker", e);
		}
	}

	  @Bean
	  public DefaultJmsListenerContainerFactory jmsListenerContainerFactory() {
	    DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
	    factory.setConnectionFactory(activeMQConnectionFactory());
	    factory.setConcurrency("3-10");
	    return factory;
	  }
	  
	  @Bean
	  public CachingConnectionFactory cachingConnectionFactory() {
	    return new CachingConnectionFactory(activeMQConnectionFactory());
	  }

	  @Bean
	  public JmsTemplate jmsTemplate() {
	    return new JmsTemplate(cachingConnectionFactory());
	  }	  
}
