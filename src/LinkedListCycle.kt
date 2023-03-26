fun hasCycle(head: ListNode?): Boolean {
    head ?: return false
    var slowNode = head
    var fastNode = head

    while (slowNode != null && fastNode != null && slowNode.`val` != fastNode.`val` ) {
        slowNode = slowNode.next
        fastNode = fastNode.next?.next
        if (slowNode!!.`val` == fastNode!!.`val` ) {
        return true
    }
    }
    return false
}