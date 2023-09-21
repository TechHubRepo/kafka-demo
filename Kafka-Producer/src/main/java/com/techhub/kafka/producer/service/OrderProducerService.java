package com.techhub.kafka.producer.service;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import com.techhub.kafka.producer.vo.OrderInfoVo;

@Service
public class OrderProducerService {

	@Autowired
	private KafkaTemplate<String, OrderInfoVo> orderKafkaTemplate;

	@Value("${my.kafka.topic.name2}")
	private String myTopicName;

	public CompletableFuture<SendResult<String, OrderInfoVo>> send(OrderInfoVo message) {
		System.out.println("Sending Message .......................................");
		System.out.println("Message : " + message);
		return orderKafkaTemplate.send(myTopicName, message);
	}
}
