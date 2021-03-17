package iii_flow_exercises.iii_solutions

import kotlinx.coroutines.flow.*
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
    runBlocking {
        try {
            fruitsFlow
                .map { fruitName -> fruitName[5] }
                .collect { letter ->
                    println(letter)
                }
        } catch (e: Exception) {
            println(e)
        }
    }
}
