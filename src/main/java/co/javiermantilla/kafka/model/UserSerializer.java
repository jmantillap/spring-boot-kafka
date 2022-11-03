package co.javiermantilla.kafka.model;

import org.apache.kafka.common.serialization.Serializer;

import com.fasterxml.jackson.databind.ObjectMapper;

public class UserSerializer implements Serializer<User> {

	@Override
	public byte[] serialize(String topic, User user) {
		byte[] retVal = null;
		ObjectMapper objectMapper = new ObjectMapper();
	    try {
	      retVal = objectMapper.writeValueAsString(user).getBytes();
	    } catch (Exception e) {
	      e.printStackTrace();
	    }
	    return retVal;
	}
		
	
}
