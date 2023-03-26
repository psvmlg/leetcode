fun intersect(nums1: IntArray?, nums2: IntArray): IntArray {

    val ans = mutableListOf<Int>()
    val map = mutableMapOf<Int, Int>()

//    for (i in nums1) {
//        map[i] = map.getOrDefault(i, 0) + 1
//    }

    for (i in nums2) {
        map.get(i)?.let {
            if (it > 0) {
                map[i] = i - 1
                ans.add(i)
            }
        }
    }
    return ans.toIntArray()
}

fun main() {
    intersect(intArrayOf(4, 9, 5), intArrayOf(9,4,9,8,4))
}