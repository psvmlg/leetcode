import kotlin.concurrent.thread

fun main() {

    foo()
}

fun passLambda(lambda: () -> Unit) {
    lambda()
}


fun foo() {
    listOf(1, 2, 3, 4, 5).forEach {
        if (it == 3) return@forEach // local return to the caller of the lambda - the forEach loop
        print(it)
    }
    print(" done with implicit label")
}