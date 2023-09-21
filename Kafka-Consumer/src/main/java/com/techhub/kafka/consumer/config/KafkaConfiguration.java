package com.techhub.kafka.consumer.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import com.techhub.kafka.producer.vo.OrderInfoVo;

@EnableKafka
@Configuration
public class KafkaConfiguration {

	@Value("${my.kafka.bootstrap-server}")
	private String kafkaBootstrapServer;

	@Value("${my.kafka.topic.group.id}")
	private String groupId;
	
	@Value("${my.kafka.topic.group.id2}")
	private String groupId2;

	@Value("${my.kafka.topic.auto.offset.reset}")
	private String offsetRest;

	@Bean
	public ConsumerFactory<String, String> stringConsumerFactory() {
		Map<String, Object> config = new HashMap<>();
		config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaBootstrapServer);
		config.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);
		config.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, offsetRest);
		config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		return new DefaultKafkaConsumerFactory<>(config);
	}

	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, String> stringKafkaListenerFactory(@Qualifier("stringConsumerFactory") ConsumerFactory<String, String> stringConsumerFactory) {
		ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory<>();
		factory.setConsumerFactory(stringConsumerFactory);
		return factory;
	}
	
	@Bean
	public ConsumerFactory<String, OrderInfoVo> orderConsumerFactory() {
		Map<String, Object> config = new HashMap<>();
		config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaBootstrapServer);
		config.put(ConsumerConfig.GROUP_ID_CONFIG, groupId2);
		config.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, offsetRest);
		config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
		config.put(JsonDeserializer.TRUSTED_PACKAGES, "com.techhub.kafka.producer.vo");
		return new DefaultKafkaConsumerFactory<>(config);
	}
	
	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, OrderInfoVo> orderKafkaListenerFactory(@Qualifier("orderConsumerFactory") ConsumerFactory<String, OrderInfoVo> orderConsumerFactory) {
		ConcurrentKafkaListenerContainerFactory<String, OrderInfoVo> factory = new ConcurrentKafkaListenerContainerFactory<>();
		factory.setConsumerFactory(orderConsumerFactory);
		return factory;
	}
}
