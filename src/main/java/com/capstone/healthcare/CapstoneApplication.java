package com.capstone.healthcare;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.capstone.healthcare")
@EnableJpaRepositories(basePackages = "com.capstone.healthcare.dal.jpa")
@EntityScan(basePackages = "com.capstone.healthcare.dal.dataobject")
public class CapstoneApplication {

	public static void main(String[] args) {
		SpringApplication.run(CapstoneApplication.class, args);
	}

}
