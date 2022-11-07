import java.util.concurrent.Executors

fun runUsingThreadPoll() {
    val num = 3
    val pool = Executors.newFixedThreadPool(num)

    try {
        for (i in 0..num) {
            pool.execute {
                println("current-thread: ${Thread.currentThread().name}")
            }
        }
    } finally {
        pool.shutdown()
    }
}