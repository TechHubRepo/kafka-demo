package com.techhub.kafka.producer.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import com.techhub.kafka.producer.vo.OrderInfoVo;

@Configuration
public class KafkaConfiguration {

	@Value("${my.kafka.bootstrap-server}")
	private String kafkaBootstrapServer;

	@Bean
	public ProducerFactory<String, String> stringProducerFactory() {
		Map<String, Object> config = new HashMap<>();
		config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaBootstrapServer);
		config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		return new DefaultKafkaProducerFactory<>(config);
	}

	@Bean
	public KafkaTemplate<String, String> stringKafkaTemplate(@Qualifier("stringProducerFactory") ProducerFactory<String, String> stringProducerFactory) {
		return new KafkaTemplate<>(stringProducerFactory);
	}

	@Bean
	public ProducerFactory<String, OrderInfoVo> orderProducerFactory() {
		Map<String, Object> config = new HashMap<>();
		config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaBootstrapServer);
		config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
		return new DefaultKafkaProducerFactory<>(config);
	}

	@Bean
	public KafkaTemplate<String, OrderInfoVo> orderKafkaTemplate(@Qualifier("orderProducerFactory") ProducerFactory<String, OrderInfoVo> orderProducerFactory) {
		return new KafkaTemplate<>(orderProducerFactory);
	}
}
