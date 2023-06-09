package com.techhub.kafka.config;

import org.apache.kafka.common.serialization.Serializer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.techhub.kafka.dto.Student;

public class StudentJsonSerializer implements Serializer<Student> {

	private final ObjectMapper objectMapper = new ObjectMapper();

	@Override
	public byte[] serialize(String topic, Student data) {

		try {
			return objectMapper.writeValueAsBytes(data);
		} catch (JsonProcessingException e) {
			return new byte[0];
		}
	}

}
