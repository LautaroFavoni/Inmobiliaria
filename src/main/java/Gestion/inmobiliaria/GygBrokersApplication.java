package Gestion.inmobiliaria;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication()
public class GygBrokersApplication {

	public static void main(String[] args) {
		SpringApplication.run(GygBrokersApplication.class, args);
	}

}
