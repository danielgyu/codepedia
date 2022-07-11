package basics

fun runCompanions() {
    println(Companions.name)
    Companions.shout()
}

class Companions(val year: Int) {
    companion object {
        var name: String = "KGLEE"

        fun shout(): Unit {
            println("HELLO !!!")
        }
    }
}