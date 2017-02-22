package participants;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.sql.Date;

@SpringBootApplication
public class Application {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
    	SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner demo(ParticipantRepository repository){

        return (args) -> {
            Participant pepe = new Participant("pepe", "pepe", "pepe@pepe.com", new Date(123),
                    "pepe", "pepe", "pepe", "pepe");
            repository.save(pepe);
            Participant participant = repository.findParticipantByEmailAndPassword
                    ("pepe@pepe.com", "pepe");
            log.info(participant.toString());

        };
    }
}