class LengthOfLastWord {
    fun lengthOfLastWord(s: String): Int {
        var start = 0

        var ansStart = -1
        var ansEnd = -1
        while (start < s.length) {
            if (s[start] != ' ') {
                ansStart = start
                ansEnd = start
                while (ansEnd < s.length && s[ansEnd] != ' ') {
                    ansEnd += 1
                    start = ansEnd
                }
            } else {
                start += 1
            }
        }
        return ansEnd - ansStart
    }
}