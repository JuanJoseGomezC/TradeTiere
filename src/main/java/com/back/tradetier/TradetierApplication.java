package com.back.tradetier;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class TradetierApplication {

	public static void main(String[] args) {
		SpringApplication.run(TradetierApplication.class, args);
	}

}
