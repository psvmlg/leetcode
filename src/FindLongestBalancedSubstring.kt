fun findTheLongestBalancedSubstring(s: String): Int {
    if (s.length < 2) return 0

    var start = 0
    var ans = Int.MIN_VALUE

    while (start < s.length) {
        var zeros = 0
        var ones = 0

        while (start < s.length && s[start] == '0') {
            zeros += 1
            start += 1
        }

        while(start < s.length && s[start] == '1') {
            ones += 1
            start += 1
        }

        ans = ans.coerceAtLeast(zeros.coerceAtMost(ones) * 2)
    }
    return ans
}

fun main() {
    findTheLongestBalancedSubstring("0011")
}