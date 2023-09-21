package com.techhub.kafka.producer.service;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

@Service
public class StringProducerService {

	@Autowired
	private KafkaTemplate<String, String> stringKafkaTemplate;

	@Value("${my.kafka.topic.name}")
	private String myTopicName;

	public CompletableFuture<SendResult<String, String>> send(String message) {
		System.out.println("Sending Message .......................................");
		System.out.println("Message : " + message);
		return stringKafkaTemplate.send(myTopicName, message);
	}
}
