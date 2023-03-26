import java.util.PriorityQueue;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class MergeKSortedList {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        ListNode head = new ListNode();
        ListNode tail = head;
        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>((a, b) -> a.val - b.val);


        for (ListNode node : lists) {
            if (node != null) {
                queue.offer(node);
            }
        }

        while (queue.size() > 0) {
            ListNode smallest = queue.poll();
            tail.next = smallest;
            tail = smallest;
            if (smallest.next != null) {
                queue.offer(smallest.next);
            }
        }

        return head.next;
    }

}