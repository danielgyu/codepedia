package com.hismaylfy.messenger

import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

data class SignalDTO(val lat: Long, val lng: Long)

@Service
class SignalService(
    private val repository: SignalRepository
) {

    @Transactional
    fun receiveSignal(signalDTO: SignalDTO) {
        val signal = Signal(lat=signalDTO.lat, lng=signalDTO.lng)
        repository.saveSignal(signal=signal)
    }
}