package pe.com.bootcamp.microservice.card;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class ProjectOneMsCardApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectOneMsCardApplication.class, args);
	}

}