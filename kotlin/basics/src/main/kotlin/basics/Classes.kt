package basics

class Classes(val year: Int, color: String) {
    var thisCity: String = "Seoul"

    var thisColor: String = color
        set(value) {
            if (value.equals("Red")) {
                println("Is Red!!!")
            }
            field = value
        }

    init {
        println("in Classes!!!")
    }

    constructor(year: Int, color: String, city: String): this(year, color) {
        thisCity = city
    }
}