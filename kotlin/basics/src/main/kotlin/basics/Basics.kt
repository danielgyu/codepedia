package basics

import java.lang.RuntimeException

fun runBasic(): Unit {
    val b: Basics = Basics()
    b.calculate()
    println(b.ternary())
    b.tryCatch()
    println(b.namedArguments())
    b.iterating()
}

class Basics {
    fun iterating() {
        val list: IntArray = intArrayOf(1, 2, 3, 4)
        for (i in 0..3) print(i)
        println()
        for (i in list) print(i)
        println()
        println("list.indices: ${list.indices}")
    }

    fun namedArguments(name: String = "KUNGYU", surname: String = "LEE"): String {
        return "$surname $name"
    }

    fun calculate(): Unit {
        val one = 1
        val two = 2
        println("1 + 2 is ${one + two}")
    }

    fun ternary(): String {
        return if (1 < 2) "always" else "never"
    }

    fun tryCatch(): Unit {
        return try {
            if (1 < 2) {
                throw RuntimeException("fail")
            } else {
                println("never")
            }
        } catch (ex: Exception) {
            println("caught exception")
        } finally {
            println("finally")
        }
    }
}