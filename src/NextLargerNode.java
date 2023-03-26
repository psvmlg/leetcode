
import java.util.ArrayList;
import java.util.Stack;

public class NextLargerNode {
    public int[] nextLargerNodes(ListNode head) {
        if (head == null) {
            return new int[]{};
        }
        Stack<Pair> stack = new Stack<>();
        ArrayList<Integer> array = new ArrayList<>();

        ListNode a = head;
        int count = 0;
        while(a != null) {
            count += 1;
            array.add(a.val);
            a = a.next;
        }

        int[] ans = new int[count];

        ListNode b = head;
        int index = 0;
        while(b != null) {
            if (stack.size() > 0) {
                if (stack.peek().node.val >= b.val) {
                    stack.push(new Pair(index, b));
                } else {
                    while(stack.size() > 0 && stack.peek().node.val < b.val) {
                        int prevIndex = stack.pop().index;
                        ans[prevIndex] = b.val;
                    }
                    stack.push(new Pair(index, b));
                }
            } else {
                stack.push(new Pair(index, b));
            }
            b = b.next;
            index += 1;
        }
        return ans;
    }

    class Pair {
        public Integer index;
        public ListNode node;

        public Pair(int index, ListNode node) {
            this.index = index;
            this.node = node;
        }
    }
}
