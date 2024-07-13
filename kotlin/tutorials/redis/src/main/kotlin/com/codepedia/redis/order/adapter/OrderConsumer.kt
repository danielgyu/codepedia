package com.codepedia.redis.order.adapter

import com.codepedia.redis.order.service.OrderInputPort
import com.codepedia.redis.order.service.OrderMessage
import com.codepedia.redis.order.service.OrderUsecase
import io.lettuce.core.api.StatefulRedisConnection
import org.springframework.data.redis.core.RedisTemplate

class OrderConsumer(
    val usecase: OrderUsecase,
    val template: RedisTemplate<String, String>,
) : OrderInputPort{
    override fun consumeMessage() {
        while (true) {
            template.

            val message = OrderMessage(key = "key", value = "value")
            usecase.saveMessage(message)
        }
    }
}