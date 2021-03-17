package iii_flow_exercises.iii_solutions

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking

fun main() {
    // Create a iii_flow that emits three Fruit strings.
    val fruitsFlow: Flow<String> = flowOf(
        "Banana",
        "Apple",
        "Tangerine"
    )

    // Collect the Fruit strings and print them to the console.
    runBlocking {
        fruitsFlow.collect { fruit ->
            println(fruit)
        }
    }
}
