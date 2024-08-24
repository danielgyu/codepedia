package com.hismayfly.batching

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class BatchingApplication

fun main(args: Array<String>) {
	runApplication<BatchingApplication>(*args)
}
