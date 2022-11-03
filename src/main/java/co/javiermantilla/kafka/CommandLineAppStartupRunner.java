package co.javiermantilla.kafka;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import co.javiermantilla.kafka.model.User;
import co.javiermantilla.kafka.producer.KafkaJsonProducer;
import co.javiermantilla.kafka.producer.KafkaStringProducer;

@Component
public class CommandLineAppStartupRunner implements CommandLineRunner {

	private final KafkaJsonProducer jsonProducer;
	private final KafkaStringProducer stringProducer;

	public CommandLineAppStartupRunner(KafkaJsonProducer jsonProducer, KafkaStringProducer stringProducer) {
		this.jsonProducer = jsonProducer;
		this.stringProducer = stringProducer;
	}

	@Override
	public void run(String... args) throws Exception {
		jsonProducer.sendMessage(new User("Larry"));
		jsonProducer.sendMessage(new User("The Edge"));
		jsonProducer.sendMessage(new User("Charly"));

		for (int i = 0; i < 10; i++) {
			stringProducer.sendMessage("Hello kafka !! " + i);
			//Thread.sleep(2000);
		}

	}
}
