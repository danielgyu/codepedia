import basics.Basics
import basics.Classes

fun main(args: Array<String>) {
    /*
    val b: Basics = Basics()
    b.calculate()
    println(b.ternary())
    b.tryCatch()
    println(b.namedArguments())
    b.iterating()
     */

    val c: Classes = Classes(2020, "BLUE")
    println(c.thisCity)
    println(c.thisColor)
    c.thisColor = "Red"
}