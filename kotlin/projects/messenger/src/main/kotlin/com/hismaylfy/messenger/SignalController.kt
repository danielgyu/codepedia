package com.hismaylfy.messenger

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

data class SignalRequest(val lat: Long, val lng: Long)

@RestController
class SignalController(
    private val service: SignalService
) {

    @PostMapping("/signals")
    fun receiveSignal(@RequestBody signalRequest: SignalRequest): ResponseEntity<String>{
        service.receiveSignal(signalDTO = SignalDTO(signalRequest.lat, signalRequest.lng));
        return ResponseEntity("success", HttpStatus.OK)
    }
}
