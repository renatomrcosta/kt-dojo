package iii_flow_exercises.i_rxjava

import io.reactivex.Observable

fun main() {
    // Create an Observable that emits three Fruit strings.
    val fruitsObservable: Observable<String> = Observable.just(
        "Banana",
        "Apple",
        "Tangerine"
    )

    // Subscribe to the Fruit Observable and print each of its emissions to the console.
    fruitsObservable.subscribe { fruit ->
        println(fruit)
    }
}
