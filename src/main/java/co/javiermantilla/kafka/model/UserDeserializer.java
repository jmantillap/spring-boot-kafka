package co.javiermantilla.kafka.model;

import java.util.Map;

import org.apache.kafka.common.serialization.Deserializer;

import com.fasterxml.jackson.databind.ObjectMapper;

public class UserDeserializer implements Deserializer<User> {

	@Override
	public void close() {
		 throw new UnsupportedOperationException("notImplemented() cannot be performed because ...");
	}

	@Override
	public void configure(Map<String, ?> arg0, boolean arg1) {
		throw new UnsupportedOperationException("notImplemented() cannot be performed because ...");
	}

	@Override
	public User deserialize(String arg0, byte[] arg1) {
		ObjectMapper mapper = new ObjectMapper();
		User user = null;
		try {
			user = mapper.readValue(arg1, User.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

}