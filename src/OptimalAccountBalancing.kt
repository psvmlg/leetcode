fun main() {
    val o = OptimalAccountBalancing()
    o.minTransfers(
        arrayOf(
            intArrayOf(0, 1, 1),
            intArrayOf(0, 2, 2),
            intArrayOf(0, 3, 3),
            intArrayOf(0, 4, 3),
            intArrayOf(0, 5, 3)
        )
    )
}

class OptimalAccountBalancing {
    var minAns = Int.MAX_VALUE
    fun minTransfers(transactions: Array<IntArray>): Int {
        val register = mutableMapOf<Int, Int>()
        val positives = mutableListOf<IntArray>()
        val negatives = mutableListOf<IntArray>()

        for (entry in transactions) {
            register[entry[0]] = register.getOrDefault(entry[0], 0) - entry[2]
            register[entry[1]] = register.getOrDefault(entry[1], 0) + entry[2]
        }

        for ((person, value) in register) {
            if (value > 0) {
                positives.add(intArrayOf(person, value, 0))
            } else if (value < 0) {
                negatives.add(intArrayOf(person, value, 0))
            }
        }
        helper(positives, negatives, 0)
        return minAns
    }

    fun helper(positives: MutableList<IntArray>, negatives: MutableList<IntArray>, depth: Int) {
        var negative: IntArray? = null
        for (i in negatives) {
            if (i[2] == 0) {
                negative = i
            }
        }

        if (negative == null || negatives.size == 0) {
            minAns = Math.min(minAns, depth)
            return
        }

        for (positive in positives) {
            if (positive[2] == 1) {
                continue
            }
            if (-negative[1] == positive[1]) {
                negative[2] = 1
                positive[2] = 1
                helper(positives, negatives, depth + 1)
                negative[2] = 0
                positive[2] = 0
            } else if (-negative[1] > positive[1]) {
                positive[2] = 1
                negative[1] += positive[1]
                helper(positives, negatives, depth + 1)
                positive[2] = 0
                negative[1] -= positive[1]
            } else {
                negative[2] = 1
                positive[1] += negative[1]
                helper(positives, negatives, depth + 1)
                negative[2] = 0
                positive[1] -= negative[1]
            }
        }
    }
}