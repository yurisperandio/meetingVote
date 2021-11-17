package br.com.meetingVote;

import br.com.meetingVote.model.Person;
import br.com.meetingVote.repository.PersonRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.TimeZone;

@EntityScan(basePackages = "br.com.meetingVote.model" )
@SpringBootApplication
public class MeetingVoteApplication {

	public static void main(String[] args) {
		//ConfigurableApplicationContext configurableApplicationContext =
				SpringApplication.run(MeetingVoteApplication.class, args);
		//PersonRepository personRepository = configurableApplicationContext.getBean(PersonRepository.class);
		//Person myPerson = new Person("Yuri", "40428170846");
		//personRepository.save(myPerson);
	}


}
