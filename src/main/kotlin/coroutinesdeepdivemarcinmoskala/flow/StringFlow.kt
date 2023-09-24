package coroutinesdeepdivemarcinmoskala.flow

fun interface FlowCollector {
    suspend fun emit(value: String)
}

interface Flow {
    suspend fun collect(collector: FlowCollector)
}

fun flow(builder: suspend FlowCollector.() -> Unit) = object : Flow {
    override suspend fun collect(collector: FlowCollector) {
        println("3")
        collector.builder()
        println("4")
    }
}

suspend fun main() {
//    val builder: suspend FlowCollector.() -> Unit = {
//        emit("A")
//        emit("B")
//        emit("C")
//    }
//    val flow: Flow = object : Flow {
//        override suspend fun collect(collector: FlowCollector) {
//            collector.builder()
//        }
//    }
    flow {
//        println("1")
//        emit("A")
//        println("2")
//        println("5")
//        emit("B")
//        println("6")
    }.collect { println(it) }

}