package com.techhub.kafka.controller;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.support.SendResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.techhub.kafka.dto.Student;
import com.techhub.kafka.service.Producer;

@RestController
public class ProducerController {

	@Autowired
	public Producer producer;

	@PostMapping(value = { "/produce" })
	public ResponseEntity<String> produceTextMessage(@RequestBody Student student) {
		CompletableFuture<SendResult<String, Student>> result = producer.send(student);
		StringBuilder msgBuilder = new StringBuilder("PRODUCED : ");
		msgBuilder.append(student.toString()).append("\n").append(result.toString());
		return ResponseEntity.of(Optional.of(msgBuilder.toString()));
	}
}
