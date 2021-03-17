package iii_flow_exercises.i_reactor

import reactor.core.publisher.Flux


private const val FREEZING_POINT_KELVIN = 273.15

// Add an extension function to Flux<Int> that filters out numbers below the freezing point
//  of water in Kelvin.
private fun Flux<Int>.filterIfBelowFreezing(): Flux<Int> =
    filter { temperature -> temperature <= FREEZING_POINT_KELVIN }

fun main() {
    // Create an Flux from the numbers 1 through 1000.
    // Apply your new extension function to the iii_flow you created.
    // Collect the integers emitted and print them to the console.
    Flux.fromIterable(1..1000)
        .filterIfBelowFreezing()
        .subscribe { temperature ->
            println(temperature)
        }
}
