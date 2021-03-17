package iii_flow

private fun mySequence(): Sequence<Int> = sequence {
    for (i in 1..10) {
        Thread.sleep(100)
        yield(i)
    }
}

/**
 * Sequences are a blocking construct to handle cold streams. Interesting to use when operations may be time consuming!
 *
 * The interesting comparison here is the behavior of a simple iterable chain of operations vs a cold (synchronous) stream made by the sequence definition.
 * The iterable has to complete complete all operations in a single operator, then pass it to the next (check print order)
 * On the other hand, a cold stream will, only when collected, operate in tandem: you'll see the console printing alternating filter/mapping operations!
 * TIP: Try omitting the .forEach() operation, substituting it with the .onEach() operator. Why did the behavior change the way it did?
 */
fun main() {
    println("Iterable operation")
    (1..10).asIterable()
        .filter {
            println("filtering $it")
            it <= 10
        }
        .forEach {
            println("printing $it")
        }

    println("Sequence operation")
    mySequence()
        .filter {
            println("filtering $it")
            it <= 10
        }
        .forEach { println("printing $it") }
}
