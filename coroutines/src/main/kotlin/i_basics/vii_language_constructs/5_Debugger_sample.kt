package i_basics.vii_language_constructs

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.asCoroutineDispatcher
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import util.trace
import java.util.concurrent.Executors
import kotlin.random.Random

private val RNGesus = Random(System.currentTimeMillis())

private val MyCoroutineScope = CoroutineScope(
    Executors.newFixedThreadPool(8).asCoroutineDispatcher()
)

/**
 * Debug this. I dare you. I double dare you!
 */
fun main() {
    runBlocking {
        repeat(10) {
            launch(Dispatchers.Default) {
                Thread.sleep(RNGesus.nextLong(1_000, 2_500))
                trace("Hey, I'm doing some work out here!")
            }
        }

        repeat(20) {
            MyCoroutineScope.launch {
                Thread.sleep(RNGesus.nextLong(1_000, 2_500))
                trace("Hey, I'm doing some work out here!")
            }
        }
    }
}
