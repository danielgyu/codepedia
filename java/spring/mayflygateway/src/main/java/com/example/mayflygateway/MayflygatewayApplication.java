package com.example.mayflygateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@SpringBootApplication
public class MayflygatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(MayflygatewayApplication.class, args);
	}

}
