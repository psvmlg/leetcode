import java.util.*
import kotlin.collections.LinkedHashMap
import kotlin.math.min

class StripeInterviewQuestion {
    fun getBestTimeForListOfServers(input: String): MutableList<Int> {

        val array = input.split(" ")
        val stack = Stack<String>()
        val ans = mutableListOf<Int>()
        for (elem in array) {
            if (elem == "BEGIN") {
                stack.push("BEGIN")
            } else if (elem == "END") {
                val curElem = stack.pop()
                ans.add(getBestTime(curElem))
            } else {
                if (stack.peek() != "BEGIN" && stack.peek() != "END") {
                    stack.push(stack.pop() + elem)
                } else {
                    stack.push(elem)
                }
            }
        }
        println(ans)
        return ans
    }

    fun <T> List<T>.findIndex(input: T, fromIndex: Int): Int {
        val index = this.subList(fromIndex, this.size).indexOf(input)
        return if (index < 0) {
            index
        } else {
            index + fromIndex
        }
    }

    fun getBestTime(string: String): Int {
        var minPenalty = Int.MAX_VALUE
        var lowestIndex = -1
        for (i in 0..string.length) {
            val penalty = getPenalty(string, i)
            if (penalty < minPenalty) {
                lowestIndex = i
                minPenalty = penalty
            }
        }
        return lowestIndex
    }

// Test case to test the case where all are on, in that case index should be 1 greater than input.
// Test case to test the case where all are off, in that case zero.
// Confirm if we need to return the first index.

    fun getPenalty(string: String, time: Int): Int {
        var penalty = 0
        for (i in string.indices) {
            val cur = string[i]
            if (cur == '0' && i >= time) { // On case
                penalty += 1
            } else if (cur == '1' && i < time) { // Off case
                penalty += 1
            }
        }

        return penalty
    }
}

fun main() {
}