class Solution {
    fun insert(intervals: Array<IntArray>, newInterval: IntArray): Array<IntArray> {
        if (intervals.isEmpty()) return arrayOf(newInterval)
        val ans = mutableListOf<IntArray>()
        var isTaken: Boolean = false
        var pastInterval: IntArray? = null
        for (i in intervals.indices) {
            if (pastInterval != null) {
                if (isOverLap(pastInterval, intervals[i])) {
                    pastInterval = intArrayOf(Math.min(pastInterval[0], intervals[i][0]), Math.max(pastInterval[1], intervals[i][1]))
                } else {
                    ans.add(pastInterval)
                    ans.add(intervals[i])
                    pastInterval = null
                }
            } else {
                if (isOverLap(newInterval, intervals[i])) {
                    isTaken = true
                    pastInterval = intArrayOf(Math.min(newInterval[0], intervals[i][0]), Math.max(newInterval[1], intervals[i][1]))
                } else {
                    if (newInterval[0] < intervals[i][0] && !isTaken) {
                        isTaken = true
                        ans.add(newInterval)
                    }
                    ans.add(intervals[i])
                }
            }
        }
        if (pastInterval != null) {
            ans.add(pastInterval)
        }
        if (!isTaken) {
            ans.add(newInterval)
        }
        return ans.toTypedArray()
    }

    fun isOverLap(a: IntArray, b: IntArray): Boolean {
        if ((Math.max(a[1], b[1]) - Math.min(a[0], b[0])) > (a[1] - a[0]) + (b[1] - b[0])) {
            return false
        }
        return true
    }
}

fun main() {
    val f = Array<Array<Int>>(4) {
        Array(5){0}
    }
    print(f[0])
}