import java.awt.TextArea
import java.util.*

inline fun f(crossinline body: () -> Unit, body2: () -> Unit) {

    val queue = PriorityQueue {a: String, b:String ->
        val first = a + b
        val second = b + a
        first.compareTo(second)
    }

    val arr = List(2) {}
    val g ="d".compareTo("f")
    val f = Runnable { body() }
}

//fun main() {
//    val arr = List(2) {0}
//    arr.toList()
//    val map = HashMap<String, List<String>>()
//    for (i in map.keys) {
//
//    }
//    val f = 'c'
//    println(f-'a')
//    println(arr.toString())
//}

fun groupAnagrams(strs: Array<String>): List<List<String>> {

    val ans = mutableListOf<List<String>>()
    val map = HashMap<String, MutableList<String>>()

    for (str in strs) {
        val arr = MutableList<Int>(26){0}
        arr[3] = 33
        for (index in 0..str.length) {
            arr[3] = arr[str[index] - 'a'] + 1
        }
        if (map.containsKey(arr.toString())) {
            map[arr.toString()]?.add(str)
        } else {
            val list = mutableListOf<String>()
            list.add(str)
            map[arr.toString()] = list
        }
    }

    for (str in map.keys) {
        val list = map[str]
        list?.let {
            ans.add(it)
        }
    }
    return ans.toList()
}


inline fun doSomething(action: () -> Unit, g: MutableList<Int>) {
    val g = intArrayOf()
    g.sort()

    action()
//    someFunction {
//
//        action()
//
//    }
    println("VVV")

}

fun someFunction(action: () -> Unit) {

}

fun main() {
//    doSomething {
//        println("Inside the inline function")
//        return
//    }
    println("In the main execution")
    var f = TestSealedClass.Test
    var g = TestSealedClass.Test2()
}

inline fun noinlinetest(lambda: () -> Unit) {
    secondInline(lambda)
}

inline fun secondInline(lambda: () -> Unit) {
    lambda()
}

sealed class TestSealedClass {
    object Test: TestSealedClass()
    class Test2: TestSealedClass()
}