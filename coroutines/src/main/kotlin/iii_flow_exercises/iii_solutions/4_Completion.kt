package iii_flow_exercises.iii_solutions

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.runBlocking

fun main() {
    // Create a iii_flow that emits three Fruit strings.
    val fruitsFlow: Flow<String> = flowOf(
        "Banana",
        "Apple",
        "Tangerine"
    )

    // Collect the Fruit strings and print each of their sixth letters to the console.
    // Handle any out of bounds exceptions.
    // Print out a message when your iii_flow completes.
    runBlocking {
        try {
            fruitsFlow
                .map { fruitName -> fruitName[5] }
                .collect { letter ->
                    println(letter)
                }
        } catch (e: StringIndexOutOfBoundsException) {
            println(e)
        } finally {
            println("All done!")
        }
    }
}
