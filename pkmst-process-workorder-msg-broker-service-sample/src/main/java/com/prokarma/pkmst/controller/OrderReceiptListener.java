package com.prokarma.pkmst.controller;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.JmsException;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.prokarma.pkmst.model.Confirmation;
import com.prokarma.pkmst.model.Order;

@Component
public class OrderReceiptListener {

	@Autowired
	private JmsTemplate jmsTemplate;

	@Autowired
	private ObjectMapper objectMapper;

	@Value("${activemq.publisherQueue}")
	private String workOrderProcessedDest;

	@JmsListener(destination = "${activemq.listenerQueue}", containerFactory = "jmsListenerContainerFactory")
	public void receive(String message) throws JsonParseException, JsonMappingException, IOException {
		Order order = this.objectMapper.readValue(message, Order.class);
		processWorkorder(order);
		sendConfirmation(order.getSessionId());
	}

	private void sendConfirmation(String sessionId) throws JmsException, JsonProcessingException {
		Confirmation confirmation = new Confirmation();
		confirmation.setSessionId(sessionId);
		confirmation.setConfirmationId(getConfirmationId());
		this.jmsTemplate.convertAndSend(this.workOrderProcessedDest, this.objectMapper.writeValueAsString(confirmation));
	}

	private String getConfirmationId() {
		return String.valueOf(Math.abs(new Random().nextInt()));
	}

	private void processWorkorder(Order order) {
		// processing order..

		// I am doing some really busy work .. Got to place order to my shop floor
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
