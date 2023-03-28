class SwapNodesInPairs {
    fun swapPairs(head: ListNode?): ListNode? {
        if (head == null) return null

        val curNode = head
        val nextNode = head.next
        if (nextNode == null) {
            return curNode
        }
        val nextToNextNode = nextNode.next

        nextNode.next = curNode
        curNode.next = swapPairs(nextToNextNode)
        return nextNode
    }
}