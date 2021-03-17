package ii_flow_exercises.iii_solutions

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import util.trace

private const val FREEZING_POINT_KELVIN = 273.15

private fun Flow<Int>.filterIfBelowFreezing() = filter { temperature ->
    temperature <= FREEZING_POINT_KELVIN
}

fun main() {
    // Create a flow that emits the numbers 1 through 1000.
    val numbersFlow = (1..1000).asFlow()

    // Call filterIfBelowFreezing on numbersFlow in the Dispatchers.IO CoroutineContext.
    // Collect numbersFlow in the Dispatchers.Default CoroutineContext and print its
    //  emissions to the console.
    runBlocking {
        withContext(Dispatchers.Default) {
            trace("This is in the default context")
            numbersFlow.filterIfBelowFreezing()
                .flowOn(Dispatchers.IO)
                .collect { number ->
                    trace(number)
                }
        }
    }
}
