public class mergetwosortedlist {

    public static void main(String[] args) {

        ListNode a = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode b = new ListNode(1, new ListNode(3, new ListNode(4)));

        ListNode f = mergeTwoLists(a, b);

    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) {
            return null;
        }
        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        }

        ListNode f;

        if (list1.val > list2.val) {
            f = list2;
        } else {
            f = list1;
        }

        ListNode curHead = f;


        while (list1 != null && list2 != null) {
            if (list1.val > list2.val) {
                curHead.next = list2;
                list2 = list2.next;
                curHead = curHead.next;
                curHead.next = null;
            } else {
                curHead.next = list1;
                list1 = list1.next;
                curHead = curHead.next;
                curHead.next = null;
            }
        }
        if (list1 != null) {
            curHead.next = list1;
        } else {
            curHead.next = list2;
        }

        return f;
    }
}
