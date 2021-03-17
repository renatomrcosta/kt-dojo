package i_basics.x_shared_mutable_state

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
Exercise: Suppose we are implementing a Rewards Program. If a partner refers our service to a potential customer, they get paid a fixed amount of money.

So, suppose we store a relation of the amount of successful referrals for each particular partner, and we pay 10 cents per successful referral.

How can we, for each referral, validate in an external service if the referral was valid, while summing up the value to pay?
*/

private const val VALUE_PER_WEBSITE_VISIT = 10
private const val WEBSITE_VISIT_QUANTITY = 4_000

private var totalCampaignAmount = 0

private suspend fun handleVisits(
    amountOfVisits: Int,
    block: suspend (Int) -> Unit
) = coroutineScope {
    repeat(amountOfVisits) {
        launch {
            block(VALUE_PER_WEBSITE_VISIT)
        }
    }
}

fun main() {
    runBlocking(context = Dispatchers.Default) {
        handleVisits(WEBSITE_VISIT_QUANTITY) { visitPayout ->
            totalCampaignAmount += visitPayout
        }
    }
    println(totalCampaignAmount)
}
