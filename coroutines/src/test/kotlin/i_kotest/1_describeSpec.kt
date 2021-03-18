package i_kotest

import i_basics.iii_concurrency.calculateBananasForAReallyLongTime
import iii_flow.TimerStatus
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe
import kotlinx.coroutines.TimeoutCancellationException
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withTimeout

class DescribeSpecTest : DescribeSpec() {
    init {
        describe("Describe Spec test samples") {
            it("Should be able to launch coroutines out of the box!") {
                withTimeout(5_000) {
                    List(100_000) {
                        launch {
                            delay(1_000)
                            println("Job $it Complete!")
                        }
                    }
                }
            }

            it("should time-out!") {
                shouldThrow<TimeoutCancellationException> {
                    withTimeout(1000) {
                        calculateBananasForAReallyLongTime()
                    }
                }
            }

            // Running Data driven tests based on existing collections!
            TimerStatus.values().forAll { status ->
                banana(status) shouldBe true
            }
        }
    }
}
fun banana(timerStatus: TimerStatus) = true