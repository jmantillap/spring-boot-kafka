package co.javiermantilla.kafka.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.kafka.core.KafkaTemplate;
//import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

//import com.fasterxml.jackson.databind.ObjectMapper;

import co.javiermantilla.kafka.model.User;

@Component
public class KafkaJsonProducer {
	
	 private static final Logger LOGGER = LoggerFactory.getLogger(KafkaJsonProducer.class);
	
	 private final KafkaTemplate<String, User> kafkaTemplate;
	 
	 //private ObjectMapper mapper;
	 
	 public KafkaJsonProducer(@Qualifier("kafkaJsonTemplate") KafkaTemplate<String, User> kafkaTemplate) {
	        this.kafkaTemplate = kafkaTemplate;
	 }
	 
	 public void sendMessage(User user) {
	        LOGGER.info("Producing message {}", user);
	        this.kafkaTemplate.send("TOPIC-DEMO-JSON", user);
	 }
	 
}
