package ii_flow_exercises.i_reactor

import reactor.core.publisher.Flux
import reactor.core.scheduler.Schedulers
import util.trace


private const val FREEZING_POINT_KELVIN = 273.15

private fun Flux<Int>.filterIfBelowFreezing(): Flux<Int> =
    filter { temperature -> temperature <= FREEZING_POINT_KELVIN }

fun main() {
    // Create an Flux from the numbers 1 through 1000.
    // Have it execute in another Scheduler (that is, not using the main thread).
    Flux.fromIterable(1..1000)
        .filterIfBelowFreezing()
        .subscribeOn(Schedulers.newParallel("newScheduler")) // Creates a bespoke scheduler
        .subscribe { temperature ->
            trace(temperature)
        }
}
