package coroutinesdeepdivemarcinmoskala.channels

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay

//It stores values when suspend.

@OptIn(ExperimentalCoroutinesApi::class)
suspend fun main(): Unit = coroutineScope {
    val channel = produce(capacity = 3) {
        repeat(5) { index ->
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
