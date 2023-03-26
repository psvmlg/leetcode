import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class DecodeString {

    public static void main(String[] args) {
        DecodeString d = new DecodeString();
        System.out.println(d.decodeString("3[a2[c]]"));
    }

        String decodeString(String s) {
            Stack<Integer> countStack = new Stack<>();

            PriorityQueue<Integer> q = new PriorityQueue<>(Comparator.comparingInt(a -> a));

            Stack<StringBuilder> stringStack = new Stack<>();
            StringBuilder currentString = new StringBuilder();
            int k = 0;
            for (char ch : s.toCharArray()) {
                if (Character.isDigit(ch)) {
                    k = k * 10 + ch - '0';
                } else if (ch == '[') {
                    // push the number k to countStack
                    countStack.push(k);
                    // push the currentString to stringStack
                    stringStack.push(currentString);
                    // reset currentString and k
                    currentString = new StringBuilder();
                    k = 0;
                } else if (ch == ']') {
                    StringBuilder decodedString = stringStack.pop();
                    // decode currentK[currentString] by appending currentString k times
                    for (int currentK = countStack.pop(); currentK > 0; currentK--) {
                        decodedString.append(currentString);
                    }
                    currentString = decodedString;
                } else {
                    currentString.append(ch);
                }
            }
            return currentString.toString();
        }


}
