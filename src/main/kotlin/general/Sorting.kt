package general

data class City(
    val id: Int,
    val name: String
)

fun main() {
    val cityList =
        listOf(
            City(5, "Izmir"),
            City(2, "Ankara"),
            City(1, "Antalya"),
            City(8, "Adiyaman"),
            City(4, "Afyon")
        )

    val newList = cityList.sortedByDescending {
        if (it.id > 7) {
            true
        } else {
            false
        }
    }
    println(newList.map { it.id })
}

