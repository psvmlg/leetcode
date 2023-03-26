import java.util.ArrayDeque;
import java.util.Deque;

public class LargestRectangleInHistogram {

    public static void main(String[] args) {
        LargestRectangleInHistogram l = new LargestRectangleInHistogram();
        System.out.println(l.largestRectangleArea(new int[]{2,1,2}));
    }

    public int largestRectangleArea(int[] heights) {
        Deque<Integer> stack = new ArrayDeque<>();
        int maxSize = 0;
        int length = heights.length;
        stack.push(-1);

        for (int i = 0; i < heights.length; i++) {
            if (stack.size() == 1 || heights[stack.peek()] <= heights[i]) {
                stack.push(i);
            } else {
                while(stack.size() > 1 && heights[stack.peek()] > heights[i]) {
                    int index = stack.pop();
                    maxSize = Math.max(maxSize, heights[index] * (i - (stack.peek() == -1 ? 0 : stack.peek() + 1)));
                }
                stack.push(i);
            }
        }

        while (stack.peek() != -1) {
            int currentHeight = heights[stack.pop()];
            int currentWidth = length - stack.peek() - 1;
            maxSize = Math.max(maxSize, currentHeight * currentWidth);
        }

        return maxSize;
    }
}
