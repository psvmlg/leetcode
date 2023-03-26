fun countAndSay(n: Int): String {
    if (n == 1) {
        return "1"
    } else if (n == 2) {
        return "11"
    }
    val prev = countAndSay(n - 1)
    var start = 1
    var word = prev[0]
    var count = 1
    var ans = ""

    while (start < prev.length) {
        if (word == prev[start]) {
            count += 1
        } else {
            ans += count.toString()
            ans += word.toString()
            count = 1
            word = prev[start]
        }
        if (start == prev.length - 1) {
            ans += count.toString()
            ans += word.toString()
        }

        start += 1
    }
    return ans
}

fun main() {
    println(countAndSay(4))
}