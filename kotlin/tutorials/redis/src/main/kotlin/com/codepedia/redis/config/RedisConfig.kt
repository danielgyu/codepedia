package com.codepedia.redis.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.redis.connection.RedisConnectionFactory
import org.springframework.data.redis.listener.RedisMessageListenerContainer
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter

@Configuration
class RedisConfig {
    @Bean
    fun redisContainer(
       redisConnectionFactory: RedisConnectionFactory,
       listenerAdapter: MessageListenerAdapter,
    ): RedisMessageListenerContainer {
        val container = RedisMessageListenerContainer()
        container.setConnectionFactory(redisConnectionFactory)
        container.addMessageListener(listenerAdapter, )
        return container
    }
}