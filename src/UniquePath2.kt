fun uniquePathsWithObstacles(obstacleGrid: Array<IntArray>): Int {
    val dp = Array<Array<Int>>(obstacleGrid.size + 1) {
        Array(obstacleGrid[0].size + 1) { 0 }
    }

    for (i in 1 until dp.size) {
        for (j in 1 until dp[0].size) {
            if (obstacleGrid[i - 1][j - 1] == 1) {
                dp[i][j] = 0
            } else {
                if (i == 1 && j == 1) {
                    dp[i][j] = 1
                } else if (i == 1) {
                    dp[i][j] = dp[i][j - 1]
                } else if (j == 1) {
                    dp[i][j] = dp[i - 1][j]
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1]
                }
            }
        }
    }
    return dp[obstacleGrid.size - 1][obstacleGrid[0].size - 1]
}

fun main() {
    print(uniquePathsWithObstacles(arrayOf(intArrayOf(0, 0, 0), intArrayOf(0, 1, 0), intArrayOf(0, 0, 0))))
}