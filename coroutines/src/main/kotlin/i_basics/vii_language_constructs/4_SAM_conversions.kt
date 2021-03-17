package i_basics.vii_language_constructs

import kotlinx.coroutines.runBlocking
import util.trace

private class MyWorker(private val runnable: Runnable) {
    fun doWork() = runnable.run()
}

/**
 * Using Functional Interfaces is really trivial now! Look at the lambda syntax when using your MyWorker class!
 */
fun main() {
    val worker = MyWorker {
        trace("Hey, I'm doing some work out here!")
    }
    val plainRunnable = Runnable {
        trace("Hi, I implement the default function (run) of this Functional Interface")
    }.run()

    runBlocking {
        repeat(10) {
            worker.doWork()
        }
    }
}
