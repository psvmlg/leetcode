class Permutations {

    var ans = mutableListOf<List<Int>>()

    fun permute(nums: IntArray): List<List<Int>> {
        helper(0, mutableListOf<Int>(), nums)
        return ans
    }

    fun helper(start: Int, list: MutableList<Int>, nums: IntArray) {

        if (list.size == nums.size) {
            ans.add(ArrayList(list))
            return
        }

        for (i in start..nums.size - 1) {
            swap(start, i, nums)
            list.add(nums[start])
            helper(start + 1, list, nums)
            list.remove(nums[start])
            swap(start, i, nums)
        }
    }

    fun swap(a: Int, b: Int, nums: IntArray) {
        var temp = nums[a]
        nums[a] = nums[b]
        nums[b] = temp
    }
}

fun main() {
    var s = Permutations()
    s.permute(intArrayOf(1, 2, 3))
}