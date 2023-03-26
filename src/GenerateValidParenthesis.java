import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GenerateValidParenthesis {
    ArrayList<String> list = new ArrayList<>();
    public static void main(String[] args) {
    }



    public List<String> generateParenthesis(int n) {
        helperMethod("", n, n);
        return list;
    }

    public void helperMethod(String currentString, int remOpen, int remClose) {
        if (remOpen < 0 || remClose < 0) {
            return;
        }

        if (remOpen == 0 && remClose == 0) {
            list.add(currentString);
            return;
        }
        if (remOpen > 0) {
            helperMethod(currentString + "(", remOpen - 1, remClose);
        }
        if (currentString.length() != 0 && remClose > 0 && remClose > remOpen) {
            helperMethod(currentString + ")", remOpen, remClose - 1);
        }
    }
}
