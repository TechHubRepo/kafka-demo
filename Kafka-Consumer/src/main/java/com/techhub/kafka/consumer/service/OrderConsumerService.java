package com.techhub.kafka.consumer.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.techhub.kafka.producer.vo.OrderInfoVo;

@Service
public class OrderConsumerService {

	@KafkaListener(topics = "${my.kafka.topic.name2}", 
			groupId = "${my.kafka.topic.group.id2}", 
			containerFactory = "orderKafkaListenerFactory")
	public void consume(OrderInfoVo message) {
		System.out.println("OrderInfoVo message: " + message);
	}
}
