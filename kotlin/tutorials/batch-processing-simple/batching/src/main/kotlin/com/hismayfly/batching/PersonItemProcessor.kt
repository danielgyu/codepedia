package com.hismayfly.batching

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.batch.item.ItemProcessor

class PersonItemProcessor(): ItemProcessor<Person, Person> {
    val logger: Logger = LoggerFactory.getLogger(this::class.java)

    override fun process(person: Person): Person {
        val transformed = Person(firstName = person.firstName.uppercase(), lastName = person.lastName.uppercase())
        logger.info("from ${person} to ${transformed}")
        return transformed
    }
}