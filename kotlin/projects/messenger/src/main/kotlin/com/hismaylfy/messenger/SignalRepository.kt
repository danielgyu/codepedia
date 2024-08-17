package com.hismaylfy.messenger

import org.springframework.stereotype.Repository

@Repository
class SignalRepository(
    private val relationalRepository: SignalRelationalRepository
    //private val eventRepository: SignalEventRepository
) {

    fun saveSignal(signal: Signal) {
        relationalRepository.save(signal)
    }
}