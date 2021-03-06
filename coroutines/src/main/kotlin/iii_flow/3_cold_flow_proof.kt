package iii_flow

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import util.trace

private fun myFlow(): Flow<Int> = flow {
    println("Flow has started")
    for (i in 1..3) {
        delay(100)
        trace("emitting index $i")
        emit(i)
    }
}

/**
 * Notice how flows are descriptive rather than imperative?
 */
fun main() = runBlocking<Unit> {
    trace("Calling the Flow builder")
    val flow = myFlow()

    trace("Calling the Flow collect")
    flow.collect { trace(it) }

    trace("Calling the Flow collect AGAIN")
    flow.collect { trace(it) }
}
