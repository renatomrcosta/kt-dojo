package ii_channels

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.collect
import util.trace

/**
 * Worker Pool implementation!
 * Uses a flow to output information if necessary
 */
private class WorkerPool<T, U>(
    private val inputChannel: ReceiveChannel<T>
) {
    private val outputList: MutableList<U> = mutableListOf()
    val outputFlow: Flow<U> = outputList.asFlow()

    suspend fun launchWorkers(amountOfWorkers: Int, work: suspend (Worker<T>) -> U) = coroutineScope {
        repeat(amountOfWorkers) { id ->
            launchWorker(id, inputChannel, work)
        }
    }

    private fun CoroutineScope.launchWorker(id: Int, channel: ReceiveChannel<T>, work: suspend (Worker<T>) -> U) =
        launch {
            for (item in channel) {
                val result = work(Worker(id = id, value = item))
                outputResult(result)
            }
        }

    private fun CoroutineScope.outputResult(result: U) = launch(Dispatchers.IO) {
        outputList.add(result)
    }
}

private data class Worker<T>(val id: Int, val value: T)

private suspend fun doSquare(value: Int): Int = coroutineScope {
    delay(1000) // simulate some work!
    value * value
}

fun main() =
    runBlocking<Unit>(Dispatchers.IO) {
        val channel = Channel<Int>()
        val pool = WorkerPool<Int, Int>(channel)

        launch {
            trace("Launching Workers")
            pool.launchWorkers(64) { worker ->
                val result = doSquare(worker.value)
                trace("WORKERID: ${worker.id} || Result $result")
                result
            }
            trace(" ALL Workers Launched")
        }

        launch {
            for (i in 1..1_000) {
                channel.send(i)
            }
            channel.close()
        }
        pool.outputFlow.collect {
            trace("Value $it printed!")
        }
    }

