import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map

suspend fun main() {
    
    flowOfNames()
        .filter { name -> name.startsWith("A") }
        .map { name -> name.uppercase() }
        .collect{name -> println(name) }
}

private suspend fun flowOfNames(): Flow<String> = flow {
    val names = listOf("Alex", "Arnold", "Michael", "Ivan", "Samuel")
    for (name in names){
        delay(1000L)
        emit(name)
    }
}