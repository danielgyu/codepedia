import java.util.concurrent.CompletableFuture

fun completableFuture() {
    val completable = CompletableFuture.supplyAsync{
        Thread.sleep(2000)
        sum(100, 250)
    }

    println("start")
    completable.thenApplyAsync(::println)

    while (!completable.isDone) {
        Thread.sleep(500)
        println("waiting...")
    }
    println("done")
}