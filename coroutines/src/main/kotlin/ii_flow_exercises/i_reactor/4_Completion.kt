package ii_flow_exercises.i_reactor

import reactor.core.publisher.Flux

fun main() {
    // Create a Flux that emits three Fruit strings.
    val fruitsFlux: Flux<String> = Flux.just(
        "Banana",
        "Apple",
        "Tangerine"
    )

    // Subscribe to the Fruit Flux and print each of their sixth letters to the console.
    // Handle any out of bounds exceptions.
    // Print out a message on completion.
    fruitsFlux
        .map { fruitName -> fruitName[5] }
        .doFinally { println("All done!") }
        .doOnComplete { println("Funny enough, this one does not work!") }
        .subscribe({ letter ->
            println(letter)
        }, { throwable ->
            println(throwable)
        })
}
