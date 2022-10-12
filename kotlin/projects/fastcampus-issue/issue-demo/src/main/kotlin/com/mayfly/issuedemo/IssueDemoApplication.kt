package com.mayfly.issuedemo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaAuditing

@SpringBootApplication
@EnableJpaAuditing
class IssueDemoApplication

fun main(args: Array<String>) {
	runApplication<IssueDemoApplication>(*args)
}
