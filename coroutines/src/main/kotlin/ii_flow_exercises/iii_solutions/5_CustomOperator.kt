package ii_flow_exercises.iii_solutions

import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking

private const val FREEZING_POINT_KELVIN = 273.15

// Add an extension function to Flow<Int> that filters out numbers below the freezing point
//  of water in Kelvin.
private fun Flow<Int>.filterIfBelowFreezing() = filter { temperature ->
    temperature <= FREEZING_POINT_KELVIN
}

fun main() {
    // Create a flow that emits the numbers 1 through 1000.
    val numbersFlow = (1..1000).asFlow()

    // Apply your new extension function to the flow you created.
    // Collect the integers emitted and print them to the console.
    runBlocking {
        numbersFlow
            .filterIfBelowFreezing()
            .collect { number ->
                println(number)
            }
    }
}
