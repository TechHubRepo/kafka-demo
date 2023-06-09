package com.techhub.kafka.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.techhub.kafka.config.Constants;
import com.techhub.kafka.dto.Student;

@Service
public class Consumer {

	@KafkaListener(topics = Constants.TOPIC_NAME, groupId = Constants.GROUP_ID)
	public void consume(Student message) {
		System.out.println("MyStudent message: " + message);
	}
}
