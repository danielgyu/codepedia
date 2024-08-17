package com.hismaylfy.messenger

import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.shouldBe
import io.mockk.*
import org.junit.jupiter.api.Assertions.*

class SignalServiceTest: ShouldSpec() {
    private val repository = mockk<SignalRepository>()
    private val service = SignalService(repository = repository)

    init {
        should("call save mock repository with appropriate call") {
            val capturedSignal = slot<Signal>()
            every { repository.saveSignal(capture(capturedSignal)) } just Runs

            val signalDTO = SignalDTO(lat=32, lng=127)
            service.receiveSignal(signalDTO)

            verify(exactly = 1) { repository.saveSignal(any()) }
            capturedSignal.captured.lat shouldBe signalDTO.lat
            capturedSignal.captured.lng shouldBe signalDTO.lng
        }
    }
}