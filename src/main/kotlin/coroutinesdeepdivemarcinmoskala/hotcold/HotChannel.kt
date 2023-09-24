package coroutinesdeepdivemarcinmoskala.hotcold

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay


// Channel(Hot) is EAGER. It is independently exist without its consumers.

@OptIn(ExperimentalCoroutinesApi::class)
private fun CoroutineScope.makeChannel() = produce {
    println("Channel Started")
    for (i in 1..10) {
        delay(1000)
        send(i)
    }
}

suspend fun main() = coroutineScope {
    val channel = makeChannel()

    delay(1000)
    println("Calling Channel...")
    for (value in channel) {
        println("From First consumption: $value")
    }
    println("Consuming again")
    for (value in channel) {
        println("From Second consumption: $value")
    }
}