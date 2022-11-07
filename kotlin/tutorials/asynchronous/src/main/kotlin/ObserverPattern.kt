import java.util.*


class Coffee(val name: String)

class Barista: Observable() {
    private lateinit var coffeeName: String

    fun orderCoffee(name: String) {
        this.coffeeName = name
    }

    fun makeCoffe() {
        setChanged()
        notifyObservers(Coffee(this.coffeeName))
    }
}

class Customer(val name: String): Observer {
    override fun update(p0: Observable?, p1: Any?) {
        val coffee = p1 as Coffee
        println("${name} got ${p1.name}")
    }
}

fun runObserverPattern() {
    val barista = Barista()
    barista.orderCoffee("americano")
    val customer = Customer("lee")

    barista.addObserver(customer)
    barista.makeCoffe()
}