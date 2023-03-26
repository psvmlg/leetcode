import java.lang.Exception

class Sample {
    private lateinit var t: String
    private val lazyVariable by lazy {
        println("FFF")
        "Vardan"
    }

    init {
        println("Vardan")
        t = "B"
    }

    constructor(t: String, u: String) {
        println("Saumya")
        this.t += u
    }

    fun printSomething() {
        print(lazyVariable)
    }
}

fun main() {
    Sample("F", "BB").printSomething()

}
enum class Users(age: Int) {
    MALE(20),
    FEMALE(200)
}

// What sealed modifier does is that it is impossible to define another subclass of this class outside of the file.
sealed class UsersSealed {

}

sealed class Response<out R>
class Success<R>(val value: R) : Response<R>()
class Failure(val error: Throwable) : Response<Nothing>()
class Something() : Response<Nothing>()

fun handle(response: Response<String>) {
    val text = when (response) {
        is Success -> "Success, data are: " + response.value
        is Failure -> response.error.localizedMessage
        else -> "FF"
    }
    print(text)
}

//fun main() {
//    var res: Response<Int> = Success(2)
//    val f = when (res) {
//        is Success -> println()
//        is Failure -> print("FF")
//        else -> print("CEFE")
//    }
//
//    var user = Users.FEMALE
//    val ff = 3
//
//    val gtt = when (ff) {
//        2 -> "ff"
//        3 -> "fff"
//        else -> "ffef"
//    }
//
//    when (user) {
//        Users.MALE -> "DD"
//        else -> "CEE"
//    }
//
//
//
//    when (user) {
//        Users.FEMALE -> println("F")
//        else -> print("fefe")
//    }
//}

// We usually use nothing to throw exceptions
fun testNothing() {
    val a = Users.FEMALE
    returnNothing()
}

//

fun returnNothing(): Nothing {
    throw Exception()
}