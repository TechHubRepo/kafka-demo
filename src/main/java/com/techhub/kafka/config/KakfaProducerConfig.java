package com.techhub.kafka.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import com.techhub.kafka.dto.Student;

@Configuration
public class KakfaProducerConfig {

	private Map<String, Object> configProps() {
		Map<String, Object> config = new HashMap<>();
		config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, Constants.BOOTSTRAP_SERVER_HOST);
		config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StudentJsonSerializer.class);
		return config;
	}

	@Bean
	public ProducerFactory<String, Student> producerFactory() {
		return new DefaultKafkaProducerFactory<>(configProps());
	}

	@Bean
	public KafkaTemplate<String, Student> kafkaTemplate() {
		return new KafkaTemplate<>(producerFactory());
	}
}
