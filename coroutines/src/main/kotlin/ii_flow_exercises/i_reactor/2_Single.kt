package ii_flow_exercises.i_reactor

import reactor.core.publisher.Mono

fun main() {
    // Create a Mono that emits an integer.
    val simpleMono: Mono<Int> = Mono.just(311)

    // Subscribe to the Mono and print its emission to the console.
    simpleMono.subscribe { number ->
        println(number)
    }
}
