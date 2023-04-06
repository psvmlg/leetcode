class ShortestWordDistance {
    fun shortestDistance(wordsDict: Array<String>, word1: String, word2: String): Int {
        var minDistance = Int.MAX_VALUE
        var firstWord: Int? = null
        var secondWord: Int? = null

        for (i in 0..wordsDict.size - 1) {
            if (wordsDict[i] == word1) {
                firstWord = i
                if (secondWord != null) {
                    minDistance = Math.min(minDistance, firstWord - secondWord)
                }
            } else if (wordsDict[i] == word2) {
                secondWord = i
                if (firstWord != null) {
                    minDistance = Math.min(minDistance, secondWord - firstWord)
                }
            }
        }

        return minDistance
    }
}