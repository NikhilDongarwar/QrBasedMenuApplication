package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication(scanBasePackages = {"com.example.controller","com.example.service","com.example.repo","com.example.entity","com.example.config"})
@EnableJpaRepositories(basePackages = "com.example.repo")
@EntityScan(basePackages = "com.example.entity")
public class QrApplication {

	public static void main(String[] args) {
		SpringApplication.run(QrApplication.class, args);
	}

}
