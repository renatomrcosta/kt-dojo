package iii_flow_exercises.i_reactor

import reactor.core.publisher.Flux

fun main() {
    // Create a Flux that emits three Fruit strings.
    val fruitsFlux: Flux<String> = Flux.just(
        "Banana",
        "Apple",
        "Tangerine"
    )

    // Subscribe to the Fruit Flux and print each of its emissions to the console.
    fruitsFlux.subscribe { fruit ->
        println(fruit)
    }
}
