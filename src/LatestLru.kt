//class LatestLru(private var capacity: Int) {
//
//    val map = mutableMapOf<Int, LruNode2>()
//    var head: LruNode2 = LruNode2(-1, -1)
//    var tail: LruNode2 = LruNode2(-1, -1)
//    var size = 0
//
//    init {
//        head.next = tail
//        tail.prev = head
//    }
//
//    fun get(key: Int): Int {
//        if (map.contains(key)) {
//            bringToHead(map[key]!!)
//            return map[key]?.value?:-1
//        }
//        return -1
//    }
//
//    fun put(key: Int, value: Int) {
//        if (map.contains(key)) {
//            map[key]?.let {bringToHead(it)}
//        } else {
//            val node = LruNode2(key, value)
//            if (size < capacity) {
//                map[key] = node
//                addNode(node)
//                size += 1
//            } else {
//                removeTail()
//                addNode(node)
//            }
//        }
//    }
//
//    fun removeNode(node: LruNode2) {
//        node.prev?.next = node.next
//        node.next?.prev = node.prev
//        node.next = null
//        node.prev = null
//    }
//
//    fun addNode(node: LruNode2) {
//        val nextNode = head.next
//        node.next = nextNode
//        node.prev = head
//        head.next = node
//        nextNode?.prev = node
//    }
//
//    fun bringToHead(node: LruNode) {
//        removeNode(node)
//        addNode(node)
//    }
//
//    fun removeTail() {
//        var curTail = tail.prev
//        curTail?.prev?.next = curTail?.next
//        curTail?.next?.prev = curTail?.prev
//        curTail?.next = null
//        curTail?.prev = null
//        map.remove(curTail?.key)
//    }
//
//}
//
//class LruNode2(val key: Int, val value: Int) {
//    var next: LruNode2? = null
//    var prev: LruNode2? = null
//}