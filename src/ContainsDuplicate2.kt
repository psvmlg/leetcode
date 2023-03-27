class ContainsDuplicate2 {
    fun containsNearbyDuplicate(nums: IntArray, k: Int): Boolean {
        if (nums.isEmpty()) return false
        var start = 0
        var end = 0
        val set = mutableSetOf<Int>()
        while (end <= k && end < nums.size) {
            if (set.contains(nums[end])) {
                return true
            }
            set.add(nums[end])
            end += 1
        }
        while (end < nums.size) {
            set.remove(nums[start])
            if (set.contains(nums[end])) {
                return true
            }
            set.add(nums[end])
            end += 1
            start += 1
        }
        return false
    }
}