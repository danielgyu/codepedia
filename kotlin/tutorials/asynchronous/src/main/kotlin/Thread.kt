fun runThread() {
    for (i in 0..5) {
        val thread = Thread{
            println("current-thread: ${Thread.currentThread().name}")
        }
        thread.start()
    }
    println("current-thread: ${Thread.currentThread().name}")
}