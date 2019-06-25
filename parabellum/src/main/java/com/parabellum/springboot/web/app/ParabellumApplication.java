package com.parabellum.springboot.web.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication

public class ParabellumApplication {

	public static void main(String[] args) {
		SpringApplication.run(ParabellumApplication.class, args);
	}

}
