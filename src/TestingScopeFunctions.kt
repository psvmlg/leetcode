fun main() {

    val a = mutableListOf<String>()
    a.add("Gupta")

    val b = a.apply {
        add("Vardan")
        sortByDescending {
            it
        }
    }

    println(b)
}