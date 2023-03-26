import java.util.*

fun gameOfLife(board: Array<IntArray>): Unit {


    val q1 = LinkedList<Int>()
    for (i in board.indices) {
        for (j in board[0].indices) {
            val neighbours = countNeighbours(i, j, board)

            if (board[i][j] == 1 || board[i][j] == 3) {
                if (neighbours < 2) {
                    board[i][j] = 3
                } else if (neighbours < 4) {

                } else {
                    board[i][j] = 3
                }
            } else if (neighbours == 3) {
                board[i][j] = 2
            }
        }
    }

    for (i in board.indices) {
        for (j in board[0].indices) {
            if (board[i][j] == 2) {
                board[i][j] = 1
            } else if (board[i][j] == 3) {
                board[i][j] = 0
            }
        }
    }
}

fun countNeighbours(i: Int, j: Int, board: Array<IntArray>): Int {
    val x = intArrayOf(1, 1, 0, -1, -1, -1, 0, 1)
    val y = intArrayOf(0, -1, -1, -1, 0, 1, 1, 1)
    var totalLive = 0
    for (index in x.indices) {
        val xFinal = x[index] + i
        val yFinal = y[index] + j
        if (xFinal >= 0 && xFinal < board.size && yFinal >= 0 && yFinal < board[0].size) {
            if (board[xFinal][yFinal] == 1 || board[xFinal][yFinal] == 3) {
                totalLive += 1
            }
        }
    }
    return totalLive
}