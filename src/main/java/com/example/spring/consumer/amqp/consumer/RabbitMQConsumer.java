package com.example.spring.consumer.amqp.consumer;

import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.spring.consumer.amqp.AmqpConsumer;
import com.example.spring.consumer.dto.Message;
import com.example.spring.consumer.service.ConsumerService;

@Component
public class RabbitMQConsumer implements AmqpConsumer<Message> {

	@Autowired
	private ConsumerService consumerService;

	@Override
	@RabbitListener(queues = "${spring.rabbitmq.request.routing-key.producer}")
	public void Consumer(Message message) {

		try {
			consumerService.action(message);
		} catch (Exception e) {
			throw new AmqpRejectAndDontRequeueException(e);
		}
	
	}
	
}
