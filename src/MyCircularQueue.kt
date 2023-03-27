class MyCircularQueue(k: Int) {
    private var capacity = 0
    private var head = Node(0)
    private var tail = Node(0)
    private var currentSize = 0

    init {
        capacity = k
        head.next = tail
        tail.prev = head
    }

    fun enQueue(value: Int): Boolean {
        if (capacity == currentSize) {
            return false
        }
        val node = Node(value)
        node.prev = tail.prev
        node.next = tail
        node.prev?.next = node
        tail.prev = node
        currentSize += 1
        return true
    }

    fun deQueue(): Boolean {
        if (currentSize == 0) {
            return false
        }
        currentSize -= 1
        val curHeadNode = head.next
        head.next = curHeadNode?.next
        curHeadNode?.next = null
        curHeadNode?.prev = null
        head.next?.prev = head
        return true
    }

    fun Front(): Int {
        if (currentSize == 0) {
            return -1
        }
        return head.next?.value?:-1
    }

    fun Rear(): Int {
        if (currentSize == 0) {
            return -1
        }
        return tail.prev?.value?:-1
    }

    fun isEmpty(): Boolean {
        return currentSize == 0
    }

    fun isFull(): Boolean {
        return currentSize == capacity
    }

}

class Node(val value: Int) {
    var next: Node? = null
    var prev: Node? = null
}

fun main() {

    var c = MyCircularQueue(8)
    c.enQueue(3)
    c.enQueue(9)
    c.enQueue(5)
    c.enQueue(0)
    c.deQueue()
    c.deQueue()
    c.isEmpty()
    c.isEmpty()
    c.Rear()
    c.Rear()
    c.deQueue()
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * var obj = MyCircularQueue(k)
 * var param_1 = obj.enQueue(value)
 * var param_2 = obj.deQueue()
 * var param_3 = obj.Front()
 * var param_4 = obj.Rear()
 * var param_5 = obj.isEmpty()
 * var param_6 = obj.isFull()
 */