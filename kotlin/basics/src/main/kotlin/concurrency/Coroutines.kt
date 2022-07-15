package concurrency

import kotlinx.coroutines.*

class Coroutines {
    suspend fun task1() {
        println("start 1")
        yield()
        println("end 1")
    }

    suspend fun task2() {
        println("start 2")
        yield()
        println("end 2")
    }

    fun run() = runBlocking {
        println("start run")
        launch { task1() }
        launch { task2() }
        println("end run")
    }
}