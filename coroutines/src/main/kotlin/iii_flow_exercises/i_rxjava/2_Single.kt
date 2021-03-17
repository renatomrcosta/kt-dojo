package iii_flow_exercises.i_rxjava

import io.reactivex.Single

fun main() {
    // Create a Single that emits an integer.
    val simpleSingle: Single<Int> = Single.just(311)

    // Subscribe to the Single and print its emission to the console.
    simpleSingle.subscribe { number ->
        println(number)
    }
}
