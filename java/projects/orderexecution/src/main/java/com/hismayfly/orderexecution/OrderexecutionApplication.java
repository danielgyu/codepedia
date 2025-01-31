package com.hismayfly.orderexecution;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class OrderexecutionApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderexecutionApplication.class, args);
	}

}
