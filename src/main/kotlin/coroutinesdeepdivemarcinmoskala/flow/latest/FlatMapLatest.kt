package coroutinesdeepdivemarcinmoskala.flow.latest

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*

fun flowFrom(elem: String) = flowOf(1, 2, 3)
    .onEach { delay(1000) }
    .map { "${it}_${elem} " }

//It works concurrently
@OptIn(ExperimentalCoroutinesApi::class)
suspend fun main() {
    flowOf("A", "B", "C")
        .flatMapLatest {
            println("HERE:$it")
            flowFrom(it)
        }
        .collect { println(it) }
}