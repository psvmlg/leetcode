import java.util.*;

public class CourseSchedule2 {

    public static void main(String[] args) {

        CourseSchedule2 s = new CourseSchedule2();
        int[] f = s.findOrder(1, new int[][]{});
        System.out.println(f);
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] ans = new int[numCourses];
        HashSet<Integer> totalSet = new HashSet<>();
        int totalRemoved = 0;
        int curPosition = 0;
        for (int i = 0; i < numCourses; i++) {
            totalSet.add(i);
        }
        HashMap<Integer, Subject> map = new HashMap<>();
        int totalEdges = 0;

        for (int i = 0; i < prerequisites.length; i++) {
            totalEdges += 1;
            int subject = prerequisites[i][0];
            int parentSubject = prerequisites[i][1];

            if (map.containsKey(subject)) {
                map.get(subject).incoming += 1;
            } else {
                Subject s = new Subject();
                s.val = subject;
                ArrayList<Integer> list = new ArrayList<>();
                s.child = list;
                s.incoming += 1;
                map.put(subject, s);
            }

            if (!map.containsKey(parentSubject)) {
                Subject s = new Subject();
                s.val = parentSubject;
                s.child = new ArrayList<>();
                if (map.containsKey(subject)) {
                    s.child.add(map.get(subject).val);
                } else {
                    Subject childSubject = new Subject();
                    childSubject.child = new ArrayList<>();
                    childSubject.val = subject;
                    map.put(subject, childSubject);
                }
                map.put(parentSubject, s);
            } else {
                Subject s = map.get(parentSubject);
                if (map.containsKey(subject)) {
                    s.child.add(map.get(subject).val);
                } else {
                    Subject childSubject = new Subject();
                    childSubject.child = new ArrayList<>();
                    childSubject.val = subject;
                    map.put(subject, childSubject);
                }

            }
        }

        LinkedList<Subject> list = new LinkedList<>();
        for (int i : map.keySet()) {
            if (map.get(i).incoming == 0) {
                list.add(map.get(i));
            }
        }

        while (list.size() > 0) {
            Subject node = list.pop();
            if (totalSet.contains(node.val)) {
                ans[curPosition] = node.val;
                curPosition += 1;
                totalSet.remove(node.val);
            }
            for (Integer child : node.child) {
                totalRemoved += 1;
                Subject childSubject = map.get(child);
                childSubject.incoming -= 1;
                if (childSubject.incoming == 0) {
                    list.add(childSubject);
                }
            }
        }

        if (totalRemoved != totalEdges) {
            return new int[0];
        } else {
            if (totalSet.size() == 0) {
                return ans;
            } else {
                Iterator<Integer> iterator = totalSet.iterator();
                while (iterator.hasNext()) {
                    ans[curPosition] = iterator.next();
                    curPosition += 1;
                }
                return ans;
            }
        }
    }

    class Subject {
        int val;
        public List<Integer> child;
        public int incoming = 0;
    }
}
