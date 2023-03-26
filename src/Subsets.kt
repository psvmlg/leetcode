class Subsets {
    var n = 0
    var length = 0
    var ans = mutableListOf<MutableList<Int>>()
    fun subsets(nums: IntArray): List<List<Int>> {
        n = nums.size
        for (i in 0..nums.size) {
            length = i
            helper(0, mutableListOf<Int>(), nums)
        }
        return ans
    }

    fun helper(start: Int, list: MutableList<Int>, nums: IntArray) {
        if (list.size == length) {
            ans.add(ArrayList(list))
        }
        for (i in start..n - 1) {
            list.add(nums[i])
            helper(i + 1, list, nums)
            list.remove(nums[i])
        }
    }
}

fun test() {
    var f = arrayOf(1, 2, 3)
    f[3]= 3
}