package ii_flow_exercises.iii_solutions

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking

fun main() {
    // Create a flow that emits an integer.
    val simpleFlow: Flow<Int> = flow {
        emit(311)
    }

    // Collect the integer and print it to the console.
    runBlocking {
        simpleFlow.collect { number ->
            println(number)
        }
    }
}
