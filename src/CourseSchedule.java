import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class CourseSchedule {

    public static void main(String[] args) {
        CourseSchedule s = new CourseSchedule();
        s.canFinish(36, new int[][]{{1, 0}, {2, 0}, {2, 1}, {3, 1}, {3, 2}, {4, 2}, {4, 3}, {5, 3}, {5, 4},
                {6, 4}, {6, 5}, {7, 5}, {7, 6}, {8, 6}, {8, 7}, {9, 7}, {9, 8}, {10, 8}, {10, 9}, {11, 9}, {11, 10},
                {12, 10}, {12, 11}, {13, 11}, {13, 12}, {14, 12}, {14, 13}, {15, 13}, {15, 14}, {16, 14}, {16, 15},
                {17, 15}, {17, 16}, {18, 16}, {18, 17}, {19, 17}, {19, 18}, {20, 18}, {20, 19}, {21, 19}, {21, 20},
                {22, 20}, {22, 21}, {23, 21}, {23, 22}, {24, 22}, {24, 23}, {25, 23}, {25, 24}, {26, 24}, {26, 25},
                {27, 25}, {27, 26}, {28, 26}, {28, 27}, {29, 27}, {29, 28}, {30, 28}, {30, 29}, {31, 29}, {31, 30},
                {32, 30}, {32, 31}, {33, 31}, {33, 32}, {34, 32}, {34, 33}, {35, 33}});
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        HashSet<Integer> unvisited = new HashSet<>();
        HashSet<Integer> curVisited = new HashSet<>();
        HashMap<Integer, List<Integer>> dependency = new HashMap<>();


        for (int i = 0; i < prerequisites.length; i++) {
            unvisited.add(prerequisites[i][0]);
            unvisited.add(prerequisites[i][1]);
            if (dependency.containsKey(prerequisites[i][0])) {
                dependency.get(prerequisites[i][0]).add(prerequisites[i][1]);
            } else {
                ArrayList<Integer> s = new ArrayList<>();
                s.add(prerequisites[i][1]);
                dependency.put(prerequisites[i][0], s);
            }
        }

        for (Integer i : dependency.keySet()) {
            if (unvisited.contains(i)) {
                if (!dfs(i, curVisited, dependency, unvisited)) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean dfs(int num, HashSet<Integer> curVisited, HashMap<Integer, List<Integer>> dependency, HashSet<Integer> unvisited) {
        curVisited.add(num);
        boolean ans = true;
        for (int child : dependency.get(num)) {
            if (curVisited.contains(child)) {
                return false;
            } else if (dependency.containsKey(child)) {
                boolean g = dfs(child, curVisited, dependency, unvisited);
                if (!g) {
                    ans = false;
                }
            }
        }
        curVisited.remove(num);
        unvisited.remove(num);
        return ans;
    }
}
