package com.example.spring.consumer.service.impl;

import org.springframework.stereotype.Service;

import com.example.spring.consumer.dto.Message;
import com.example.spring.consumer.service.ConsumerService;

@Service
public class ConsumerServiceImpl implements ConsumerService{

	@Override
	public void action(Message message) throws Exception{
		
		//throw new Exception("Erro");
		
		System.out.println(message.getText());
			
	}
	
}
