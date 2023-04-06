class GenerateParenthesis {
    val ans = mutableListOf<String>()
    fun generateParenthesis(n: Int): List<String> {
        val f = helper(n,n)
        val set = mutableSetOf<String>()
        f.forEach {
            set.add(it)
        }

        return set.toList()
    }

    fun helper(totalLength: Int, n: Int): List<String> {
        if (n == 0) {
            return mutableListOf<String>()
        }
        if (n == 1) {
            return mutableListOf("()")
        }
        val ans = helper(totalLength, n - 1)
        var firstOne = ans.map {
            "($it)"
        }
        var secondOne = ans.map {
            "()$it"
        }
        var thirdOne = ans.map {
            "$it()"
        }
        return firstOne + secondOne + thirdOne
    }
}

fun main() {
    val f = GenerateParenthesis()
    val t = f.generateParenthesis(3)
    println(t)
}