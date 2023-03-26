import java.util.HashSet;

class WordSearch {

    public static void main(String[] args) {
        System.out.println(new WordSearch().exist(new char[][]{{'A', 'B'}, {'C', 'D'}}, "CDBA"));
    }

    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (helper(board, i, j, new HashSet<String>(), word, "")) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean helper(char[][] board, int x, int y, HashSet<String> visited, String word, String current) {
        current = current + board[x][y];
        visited.add(x + "," + y);
        if (word.equals(current)) {
            visited.remove(x + "," + y);
            return true;
        } else if (word.length() <= current.length()) {
            visited.remove(x + "," + y);
            return false;
        } else if(board[x][y] != word.charAt(current.length()  - 1)) {
            visited.remove(x + "," + y);
            return false;
        }

        int[] axisX = new int[]{1, 0, -1, 0};
        int[] axisY = new int[]{0, -1, 0, 1};

        for (int i = 0; i < 4; i++) {
            int curX = x + axisX[i];
            int curY = y + axisY[i];
            if (curX < 0 || curY < 0 || curX >= board.length || curY >= board[0].length) {
                continue;
            }
            if (visited.contains(curX + "," + curY)) {
                continue;
            } else {
                if (helper(board, curX, curY, visited, word, current)) {
                    return true;
                }
            }

        }
        visited.remove(x + "," + y);
        return false;


    }
}