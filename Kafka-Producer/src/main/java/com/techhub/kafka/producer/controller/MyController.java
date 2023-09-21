package com.techhub.kafka.producer.controller;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.support.SendResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.techhub.kafka.producer.service.OrderProducerService;
import com.techhub.kafka.producer.service.StringProducerService;
import com.techhub.kafka.producer.vo.OrderInfoVo;

@RestController
public class MyController {

	@Autowired
	private StringProducerService stringProducerService;

	@Autowired
	private OrderProducerService orderProducerService;

	@GetMapping("/produce/{message}")
	public String sendMessage(@PathVariable String message) {
		CompletableFuture<SendResult<String, String>> response = this.stringProducerService.send(message);
		System.out.println("RESPONSE : " + response.toString());
		return message;
	}

	@PostMapping(value = "/produce")
	public OrderInfoVo sendMessage1(@RequestBody OrderInfoVo message) {
		CompletableFuture<SendResult<String, OrderInfoVo>> response = this.orderProducerService.send(message);
		System.out.println("RESPONSE : " + response.toString());
		return message;
	}
}
