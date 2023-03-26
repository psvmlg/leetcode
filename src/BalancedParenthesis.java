import java.util.Stack;

public class BalancedParenthesis {

    public static void main(String[] args) {
        BalancedParenthesis.solution("<");
    }
    public static String solution(String s) {
        Stack<Character> stack = new Stack<>();

        int start = 0;

        StringBuilder end = new StringBuilder();
        StringBuilder startB = new StringBuilder();

        while (start < s.length()) {

            if (s.charAt(start) == '<') {
                stack.push('<');
            } else {
                if (stack.size() == 0) {
                    startB.append('<');
                } else {
                    stack.pop();
                }
            }

            while (stack.size() > 0) {
                char c = stack.pop();
                if (c  == '<') {
                    end.append('>');
                } else {
                    startB.append('<');
                }
            }
        }
        return startB.toString() + s + end.toString();
    }

}
