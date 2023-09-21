package com.techhub.kafka.consumer.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class StringConsumerService {

	@KafkaListener(topics = "${my.kafka.topic.name}", 
			groupId = "${my.kafka.topic.group.id}", 
			containerFactory = "stringKafkaListenerFactory")
	public void consume(String message) {
		System.out.println("String message: " + message);
	}
}
