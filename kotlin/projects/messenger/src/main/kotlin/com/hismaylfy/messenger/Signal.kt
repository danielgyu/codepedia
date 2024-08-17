package com.hismaylfy.messenger

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table( name = "Signals_")
class Signal(
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val lat: Long,
    val lng: Long
) {
}