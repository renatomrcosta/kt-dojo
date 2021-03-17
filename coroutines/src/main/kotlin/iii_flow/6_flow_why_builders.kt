package iii_flow

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.runBlocking
import util.withExecutionTime

data class MyWeirdDTO(val amount: Long) {}

private suspend fun Int.toMyWeirdDTO(): MyWeirdDTO {
    delay(100)
    return MyWeirdDTO(amount = this.toLong())
}

/**
 * Check out the execution time when converting this DTO.
 * Suppoe the mapping function took a whopping 100ms, to see how they'd differ1
 */
fun main() {
    withExecutionTime {
        runBlocking {
            println("NORMAL LIST")
            listOf(1, 2, 3).map {
                println("mapping value $it")
                it.toMyWeirdDTO()
            }.forEach { println(it) }
        }
    }

    println("------")

    withExecutionTime {
        runBlocking {
            println("FLOWS GO HERE NOW")

            listOf(1, 2, 3)
                .asFlow()
                // .buffer()
                .map {
                    println("mapping iii_flow value $it")
                    it.toMyWeirdDTO()
                }
                .collect {
                    println(it)
                }
        }
    }
}
