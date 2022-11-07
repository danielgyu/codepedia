data class Car(val brand: String)

class CarIterable(val cars: List<Car> = listOf()): Iterable<Car> {
    override fun iterator(): Iterator<Car> = CarIterator(cars)
}

class CarIterator(
    val cars: List<Car> = listOf(),
    var index: Int = 0,
): Iterator<Car> {
    override fun hasNext(): Boolean {
        return index < cars.size
    }

    override fun next(): Car {
        return cars[index++]
    }
}