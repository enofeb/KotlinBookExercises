package coroutinesdeepdivemarcinmoskala.channels

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay

@OptIn(ExperimentalCoroutinesApi::class)
suspend fun main(): Unit = coroutineScope {
    val channel = produce(capacity = Channel.UNLIMITED) {
        repeat(5) { index ->
            println("Before Sent...")
            send(index)
            delay(100)
            println("Sent")
        }
    }
    println("Before Delay")
    delay(1000)
    println("After Delay")
    for (element in channel) {
        println(element)
        delay(1000)
    }
}
