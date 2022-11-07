import java.util.concurrent.Callable
import java.util.concurrent.Executors

fun useFuture() {
    val pool = Executors.newSingleThreadExecutor()
    val future = pool.submit(
        Callable {
            sum(100, 200)
        }
    )

    println(future)
    val futureResult = future.get() 
    println(futureResult)
}

fun sum(a: Int, b: Int): Int = a + b