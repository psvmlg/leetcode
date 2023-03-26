fun main() {
 A().merge(arrayOf(intArrayOf(1, 3), intArrayOf(2, 6), intArrayOf(8, 10), intArrayOf(15, 18)))

}

class A {
    fun merge(intervals: Array<IntArray>): Array<IntArray> {

        if (intervals.size <= 1) return intervals
        val ans = mutableListOf<IntArray>()
        intervals.sortBy {
            it[0]
        }

        val map = mutableMapOf<Char, Int>()

        var interval = intervals[0]
        var index = 1
        var isIntervalAdded = false

        while (index >= 0 && index < intervals.size) {
            if (intervals[index][0] <= interval[1]) {
                interval[1] = Math.max(interval[1], intervals[index][1])
                isIntervalAdded = false
            } else {
                ans.add(interval)
                interval = intervals[index]
                isIntervalAdded = true
            }
            index++
        }
        if (isIntervalAdded.not()) ans.add(interval)
        return ans.toTypedArray()
    }
}