package com.hismaylfy.messenger

import org.springframework.data.repository.CrudRepository

interface SignalRelationalRepository: CrudRepository<Signal, Long> {
}