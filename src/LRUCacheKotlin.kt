//class LRUCache(capacity: Int) {
//
//    val map = HashMap<Int, LruNode>()
//    val head = LruNode(0, 0)
//    val tail = LruNode(0, 0)
//    val cap = capacity
//
//    fun get(key: Int): Int {
//        if (map.containsKey(key)) {
//            removeNode(map[key]!!)
//            makeHead(map[key]!!)
//            return map[key]!!.nums
//        } else {
//            return -1
//        }
//    }
//
//    fun put(key: Int, value: Int) {
//        if (map.size < cap) {
//            if (map.containsKey(key)) {
//                if (head.next?.nums == key) {
//                    return
//                } else {
//                    val nodeToAdd = map[key]!!
//                    nodeToAdd.nums = value
//                    removeNode(nodeToAdd)
//                    makeHead(nodeToAdd)
//                }
//            } else {
//                val node = LruNode(key, value)
//                makeHead(node)
//                map.put(key, node)
//            }
//        } else {
//            if (map.containsKey(key)) {
//                val nodeToAdd = map[key]!!
//                nodeToAdd.nums = value
//                removeNode(nodeToAdd)
//                makeHead(nodeToAdd)
//            } else {
//                val removedNode = removeLast()
//                map.remove(removedNode?.keys)
//                val node = LruNode(key, value)
//                makeHead(node)
//                map[key] = node
//            }
//        }
//    }
//
//    private fun removeNode(node: LruNode) {
//        val prev = node.prev
//        val next = node.next
//        prev?.next = next
//        next?.prev = prev
//        node.next = null
//        node.prev = null
//    }
//
//    private fun makeHead(node: LruNode) {
//        if (head.next != null) {
//            val curNode = head.next
//            head.next = node
//            node.prev = head
//            node.next = curNode
//            curNode?.prev = node
//        } else {
//            head.next = node
//            node.prev = head
//        }
//        if (tail.prev == null) {
//            tail.prev = node
//            node.next = tail
//        }
//    }
//
//    private fun removeLast(): LruNode? {
//        if (tail.prev != null) {
//            var prev = tail.prev
//            tail.prev = tail.prev?.prev
//            tail.prev?.next = tail
//            prev?.next = null
//            prev?.prev = null
//            return prev
//        }
//        return null
//    }
//}
//
//class Node(key: Int, num: Int) {
//    var next: LruNode? = null
//    var prev: LruNode? = null
//    val keys = key
//    var nums = num
//}
//
//fun main() {
//    val cache = LRUCache(2)
//    println(cache.put(1, 1))
//    println(cache.put(2, 2))
//    println(cache.get(1))
//    println(cache.put(3, 3))
//    println(cache.get(2))
//    println(cache.put(4, 4))
//    println(cache.get(1))
//    println(cache.get(3))
//    println(cache.get(4))
//}