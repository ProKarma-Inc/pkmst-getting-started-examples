package com.prokarma.pkmst.controller;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Maps;
import com.prokarma.pkmst.model.Order;
import com.prokarma.pkmst.model.OrderConfirmation;
import com.prokarma.pkmst.model.ConfirmationFromDownstreamSystem;

import io.swagger.annotations.ApiParam;
import net.logstash.logback.encoder.org.apache.commons.lang.exception.NestableRuntimeException;

/**
 * Api implemention
 * 
 * @author pkmst
 *
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaPKMSTServerCodegen", date = "2018-02-22T21:37:34.360Z")

@Controller
public class OrderApiController implements OrderApi {
	
	private final ObjectMapper objectMapper;

	@Autowired
	private JmsTemplate jmsTemplate;
	
	@Autowired
    public SimpMessageSendingOperations messagingTemplate;
	
	
	private final Map<String, OrderConfirmation> orderConfirmationMap = Maps.newHashMap();
	
	ReentrantLock lock = new ReentrantLock();
	
	@Autowired
	public OrderApiController(ObjectMapper objectMapper) {
		this.objectMapper = objectMapper;
	}

	public ResponseEntity<Void> placeOrder(
			@ApiParam(value = "Object representing the order being placed") @RequestBody Order body,
			@RequestHeader(value = "Accept", required = false) String accept) throws Exception {
		
		this.doPlaceOrder(body, null);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@Override
	public void placeOrder(SimpMessageHeaderAccessor accessor, Order order) {
		order.setSessionId(accessor.getSessionId());
		OrderConfirmation orderConfirmation = new OrderConfirmation();
		orderConfirmation.setDollarAmount(order.getPaymentAmount());
		this.orderConfirmationMap.put(accessor.getSessionId(), orderConfirmation );		
		this.doPlaceOrder(order, accessor.getSessionId());
	}
	
	private void doPlaceOrder(Order order, String sessionId) {
		//send to work order initiation
		//send to payment processor
		TextMessageCreator textMessageCreator = new TextMessageCreator(order);
		this.jmsTemplate.send("orderReceivedForPayment.q", textMessageCreator);
		this.jmsTemplate.send("orderReceived.q", textMessageCreator);
	}

	@JmsListener(destination = "${activemq.workOrderInitiatedlistenerQueue}", containerFactory = "jmsListenerContainerFactory")
	public void receiveWorkorderPlacementConfirmation(String message) throws JsonParseException, JsonMappingException, IOException {
		ConfirmationFromDownstreamSystem conf = this.objectMapper.readValue(message, ConfirmationFromDownstreamSystem.class);
		String sessionId = conf.getSessionId();
		lock.lock();
		try {
			OrderConfirmation orderConfirmation = this.orderConfirmationMap.get(sessionId);
			orderConfirmation.setOrderPlacedConfirmationId(conf.getConfirmationId());
			if(orderConfirmation.getPaymentConfirmationId() != null) {
				this.orderConfirmationMap.remove(sessionId);
				//send confirmation to sender
				this.messagingTemplate.convertAndSend("/topic/order-placed", orderConfirmation);				
			}
		}
		finally {
			lock.unlock();
		}
		
	}

	@JmsListener(destination = "${activemq.paymentProcessedlistenerQueue}", containerFactory = "jmsListenerContainerFactory")
	public void receivePaymentProcessedConfirmation(String message) throws JsonParseException, JsonMappingException, IOException {
		ConfirmationFromDownstreamSystem conf = this.objectMapper.readValue(message, ConfirmationFromDownstreamSystem.class);
		String sessionId = conf.getSessionId();
		lock.lock();
		try {
			OrderConfirmation orderConfirmation = this.orderConfirmationMap.get(sessionId);
			orderConfirmation.setPaymentConfirmationId(conf.getConfirmationId());
			if(orderConfirmation.getOrderPlacedConfirmationId() != null) {
				this.orderConfirmationMap.remove(sessionId);
				//send confirmation to sender
				this.messagingTemplate.convertAndSend("/topic/order-placed", orderConfirmation);
			}
		}
		finally {
			lock.unlock();
		}
		
	}
	
	private final class TextMessageCreator implements MessageCreator {
		private final Order order;

		private TextMessageCreator(Order order) {
			this.order = order;
		}

		@Override
		public Message createMessage(Session session) throws JMSException {
			try {
				return session.createTextMessage(objectMapper.writeValueAsString(order));
			} catch (JsonProcessingException e) {
				throw new NestableRuntimeException("Failed to conver to JSON message", e);
			}
		}
	}

}
