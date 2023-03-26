import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class ValidParenthesis {

    public static void main(String[] args) {

    }

    public boolean isValid(String s) {
        HashMap<Character, Character> map = new HashMap<>();

        map.put('}', '{');
        map.put(')', '(');
        map.put(']', '[');

        List<Character> l = new ArrayList<>();
        l.add('{');
        l.add('(');
        l.add('[');

        Stack<Character> stack = new Stack<>();


        for (int i = 0; i < s.length(); i++) {
            if (l.contains(s.charAt(i))) {
                stack.push(s.charAt(i));
            } else {
                if (stack.isEmpty() || !stack.peek().equals(map.get(s.charAt(i)))) {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }
        return true;

    }
}
