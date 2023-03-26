import java.util.*

fun main() {
    val g = TreeNode(1).apply {
        left = TreeNode(2).apply {
            left = TreeNode(4)
        }

        right = TreeNode(3).apply {
            right = TreeNode(5)
        }
    }
    println(zigzagLevelOrder(g))
}

fun zigzagLevelOrder(root: TreeNode?): List<List<Int>> {
    val ans = mutableListOf<List<Int>>()
    if (root == null) return ans.toList()
    val queue = LinkedList<Pair<TreeNode, Int>?>()
    var isLTR = false
    var level = 0
    queue.add(Pair(root, 0))
    var list = mutableListOf<Int>()

    while (queue.isNotEmpty()) {
        val pair = queue.poll() ?: continue
        val curNode = pair.first
        val curLevel = pair.second

        if (curLevel != level) {
            level = curLevel
            isLTR = !isLTR
            ans.add(list.toList().reversed())
            list = mutableListOf<Int>()
        }
        list.add(curNode.`val`)

        if (isLTR) {
            curNode.left?.let { queue.add(Pair(it, level + 1)) }
            curNode.right?.let { queue.add(Pair(it, level + 1)) }
        } else {
            curNode.right?.let { queue.add(Pair(it, level + 1)) }
            curNode.left?.let { queue.add(Pair(it, level + 1)) }
        }
    }

    ans.add(list.toList())
    return ans.toList()
}