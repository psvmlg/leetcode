fun coinChange(coins: IntArray, amount: Int) {

    val dp = mutableListOf<IntArray>()
    val dp2 = mutableListOf<MutableList<Int>>().toTypedArray()
    dp2.sort()


    coins.forEach { _ ->
        dp.add(IntArray(amount){2})
    }

    for (coinIndex in 0..dp.size) {
        for (amount in 1..dp[0].size + 1) {
            if (coinIndex == 0) {
                if (amount % coins[coinIndex] == 0) {
                    dp[coinIndex][amount - 1] = amount / coins[coinIndex]
                } else {
                    dp[coinIndex][amount - 1] = -1
                }
            } else {
                dp[coinIndex][amount - 1]
            }
        }
    }
}

fun main() {
    println("FF")
}