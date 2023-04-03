package fr.solutec.resaevent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@SpringBootApplication
public class ResaEventsApplication {
	public static void main(String[] args) {
		SpringApplication.run(ResaEventsApplication.class, args);
	}
}