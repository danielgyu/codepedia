package com.hismaylfy.messenger

import io.kotest.core.spec.style.ShouldSpec
import io.kotest.extensions.spring.SpringExtension
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.test.web.server.LocalServerPort
import org.springframework.http.HttpStatus

@SpringBootTest(
    classes = arrayOf(MessengerApplication::class),
    webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SignalIntegrationTests {
    @Autowired private lateinit var template: TestRestTemplate
    @LocalServerPort private var port: Int? = null

    @Test
    fun testPostSignal() {
        val url = "http://localhost:${port}/signals"
        val response = template.postForEntity(url, SignalRequest(lat=32, lng=127), String::class.java)
        response.statusCode shouldBe HttpStatus.OK
    }
}
