class FormSmallestNumberFromTwoDigitArray {
    fun minNumber(nums1: IntArray, nums2: IntArray): Int {
        var smallestNumInFirst = Int.MAX_VALUE
        val set = mutableSetOf<Int>()
        for (i in nums1) {
            set.add(i)
            smallestNumInFirst = Math.min(smallestNumInFirst, i)
        }
        var lowestCommonNum = Int.MAX_VALUE
        var smallestNumInSecond = Int.MAX_VALUE
        for (i in nums2) {
            if (set.contains(i)) {
                lowestCommonNum = Math.min(lowestCommonNum, i)
            }
            smallestNumInSecond = Math.min(smallestNumInSecond, i)
        }

        if (lowestCommonNum != Int.MAX_VALUE) {
            return lowestCommonNum
        }

        if (smallestNumInFirst < smallestNumInSecond) {
            return smallestNumInFirst * 10 + smallestNumInSecond
        } else {
            return smallestNumInSecond * 10 + smallestNumInFirst
        }
    }
}