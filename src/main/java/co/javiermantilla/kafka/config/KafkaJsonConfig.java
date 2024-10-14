package co.javiermantilla.kafka.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import co.javiermantilla.kafka.model.User;

@Configuration
public class KafkaJsonConfig {

	public ProducerFactory<String, User> producerFactoryJson() {
		Map<String, Object> config = new HashMap<>();
		config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");		
		config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
		config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class.getName());
		
				
		config.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, false); // disable autocommit		
		//config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,UserDeserializer.class.getName());
		//AckMode.MANUAL_IMMEDIATE	
		//config.put("value.deserializer",UserDeserializer.class);
		//config.put("value.serializer", UserSerializer.class);
		//config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class.getName());
		//config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, UserSerializer.class.getName());
		
		return new DefaultKafkaProducerFactory<>(config);
	}

	@Bean(name = "kafkaJsonTemplate")
	KafkaTemplate<String, User> kafkaTemplateJson() {
		return new KafkaTemplate<>(this.producerFactoryJson());
	}
	

}
