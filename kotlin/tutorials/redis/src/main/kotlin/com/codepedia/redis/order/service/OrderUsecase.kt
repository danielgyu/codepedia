package com.codepedia.redis.order.service

import mu.KotlinLogging
import org.springframework.stereotype.Service

private val logger = KotlinLogging.logger {}

@Service
class OrderUsecase {
    fun saveMessage(message: OrderMessage) {
        logger.info { "saving message $message" }
    }
}