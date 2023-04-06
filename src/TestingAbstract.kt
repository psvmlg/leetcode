abstract class TestingAbstract(val g: String) {

    init {
        println(getName())
    }
    abstract fun getName(): String
}

class ConcreteTesting(val f: String): TestingAbstract(f) {
    override fun getName(): String {
        return f
    }

}

fun main() {
    var f = ConcreteTesting("Vardaan")
}