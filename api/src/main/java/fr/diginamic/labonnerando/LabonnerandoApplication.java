package fr.diginamic.labonnerando;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
@SpringBootApplication
public class LabonnerandoApplication {

	public static void main(final String[] args) {
		SpringApplication.run(LabonnerandoApplication.class, args);
	}
}
