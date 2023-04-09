import java.security.Key
import java.util.*


fun main() {
    val cache = LatestLru<Int, Int>(2)

    cache[1] = 1
    cache[2] = 2
    println(cache[1])
    cache[3] = 3
    println(cache[2])
    cache[4] = 4
    println(cache[1])
    println(cache[3])
    println(cache[4])
}

interface BaseLRUCache<K, V> {
    operator fun set(key: K, value: V)
    operator fun get(key: K): V?
    fun size(): Int
    fun clear()
}

class LatestLru<K, V>(private var capacity: Int) : BaseLRUCache<K, V> {

    private val map = mutableMapOf<K, LruNode2<K, V>>()
    private var head: LruNode2<K, V> = LruNode2(null, null)
    private var tail: LruNode2<K, V> = LruNode2(null, null)
    private var size = 0

    init {
        head.next = tail
        tail.prev = head
    }

    override fun get(key: K): V? {
        if (map.contains(key)) {
            bringToHead(map[key]!!)
            return map[key]?.value
        }
        return null
    }

    override fun set(key: K, value: V) {
        if (map.contains(key)) {
            map[key]?.let { bringToHead(it) }
            map[key]?.value = value
        } else {
            val node = LruNode2(key, value)
            if (size < capacity) {
                map[key] = node
                addNode(node)
                size += 1
            } else {
                removeTail()
                addNode(node)
                map[key] = node
            }
        }
    }

    private fun removeNode(node: LruNode2<K, V>) {
        node.prev?.next = node.next
        node.next?.prev = node.prev
        node.next = null
        node.prev = null
    }

    private fun addNode(node: LruNode2<K, V>) {
        val nextNode = head.next
        node.next = nextNode
        node.prev = head
        head.next = node
        nextNode?.prev = node
    }

    private fun bringToHead(node: LruNode2<K, V>) {
        removeNode(node)
        addNode(node)
    }

    private fun removeTail() {
        var curTail = tail.prev
        curTail?.prev?.next = curTail?.next
        curTail?.next?.prev = curTail?.prev
        curTail?.next = null
        curTail?.prev = null
        map.remove(curTail?.key)
    }

    override fun size(): Int {
        return map.size
    }

    override fun clear() {
        map.clear()
        head = LruNode2(null, null)
        tail = LruNode2(null, null)
        size = 0
    }

}

private class LruNode2<K, V>(val key: K?, var value: V?) {
    var next: LruNode2<K, V>? = null
    var prev: LruNode2<K, V>? = null
}