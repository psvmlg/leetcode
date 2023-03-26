public class SwapNodesInPair {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode current = head;
        ListNode next = head.next;
        head = next;
        current.next = swapPairs(next.next);
        next.next = current;
        return head;
    }
}
