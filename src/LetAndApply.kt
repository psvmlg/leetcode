fun main() {

    val f = "FFF"
    val s = "DD"

    f.apply {
        println(this)
    }

    f.also {
        println(it)
    }
}