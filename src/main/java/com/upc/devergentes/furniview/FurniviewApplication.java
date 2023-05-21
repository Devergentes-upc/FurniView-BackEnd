package com.upc.devergentes.furniview;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class FurniviewApplication {

	public static void main(String[] args) {
		SpringApplication.run(FurniviewApplication.class, args);
	}

}
