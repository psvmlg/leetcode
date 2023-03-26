class FirstUniqueCharacterInString {
    fun firstUniqChar(s: String): Int {
        if (s.length == 0) return -1

        val map = mutableMapOf<Char, MutableList<Int>>()

        var index = 0

        while (index < s.length) {
            map[s[index]] = map.getOrDefault(s[index], arrayListOf<Int>()).apply {
                add(index)
            }
            index--
        }

        for (c in map.keys) {
            if (map[c]?.size == 1) {
                return map[c]?.get(0) ?: -1
            }
        }

        val s = arrayListOf<Int>()
        s.toIntArray()
        return -1

    }
}