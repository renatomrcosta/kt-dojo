package ii_channels

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.SendChannel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import util.withExecutionTime

suspend fun sendValue(channel: SendChannel<String>, operation: () -> String) {
    channel.send(operation())
}

fun main() {
    withExecutionTime {
        runBlocking {
            // Many coroutines sending to the same channel
            val channel = Channel<String>()

            repeat(5) {
                launch {
                    sendValue(channel) {
                        "I am operating on coroutine #$it"
                    }
                }
            }
            // Really neat way to consume it!
            channel.receiveAsFlow().collect { println(it) }
        }

        // If you don't close the channel, it stops the CoroutineScope from being able to finish! ALways be careful with that
    }
}
