package se.nicklasrohman.backendTrainingGenerator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"se.nicklasrohman.backendTrainingGenerator"})
public class BackendTrainingGeneratorApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendTrainingGeneratorApplication.class, args);
	}

}
