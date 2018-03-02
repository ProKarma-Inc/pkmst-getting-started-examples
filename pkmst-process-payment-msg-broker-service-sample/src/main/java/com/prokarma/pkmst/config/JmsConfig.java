package com.prokarma.pkmst.config;

import org.apache.activemq.ActiveMQConnectionFactory;
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
	    ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory();
	    activeMQConnectionFactory.setBrokerURL(this.brokerUrl);

	    return activeMQConnectionFactory;
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
