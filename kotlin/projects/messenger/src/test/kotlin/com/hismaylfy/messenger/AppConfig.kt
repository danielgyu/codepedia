package com.hismaylfy.messenger

import org.mockito.Mock
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.test.web.servlet.MockMvc
import org.springframework.web.client.RestTemplate

@Configuration
class AppConfig {

    @Bean
    fun template(): TestRestTemplate = TestRestTemplate()
}