package com.techhub.kafka.service;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import com.techhub.kafka.config.Constants;
import com.techhub.kafka.dto.Student;

@Service
public class Producer {

	@Autowired
	private KafkaTemplate<String, Student> kafkaTemplate;

	public CompletableFuture<SendResult<String, Student>> send(Student message) {
		return kafkaTemplate.send(Constants.TOPIC_NAME, message);
	}
}
