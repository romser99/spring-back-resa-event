package fr.solutec.re;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@SpringBootApplication
public class ResaeventsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ResaeventsApplication.class, args);
	}

}
