package fr.solutec.re;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@CrossOrigin
@SpringBootApplication
public class ResaEventsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ResaEventsApplication.class, args);
	}

}
