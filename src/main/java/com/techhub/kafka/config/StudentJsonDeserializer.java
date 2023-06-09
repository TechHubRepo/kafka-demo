package com.techhub.kafka.config;

import java.io.IOException;

import org.apache.kafka.common.serialization.Deserializer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.techhub.kafka.dto.Student;

public class StudentJsonDeserializer implements Deserializer<Student> {

	private ObjectMapper objectMapper = new ObjectMapper();

	@Override
	public Student deserialize(String topic, byte[] data) {
		try {
			return objectMapper.readValue(data, Student.class);
		} catch (IOException e) {
			return new Student();
		}
	}

}
