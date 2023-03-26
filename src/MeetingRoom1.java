import java.util.Arrays;

public class MeetingRoom1 {

    public static void main(String[] args) {
        System.out.println(new MeetingRoom1().canAttendMeetings(new int[][]{{7,10},{2, 4}}));
    }

    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        for (int i = 0; i < intervals.length - 1; i++) {
            if (intervals[i][1] > intervals[i + 1][0]) {
                return false;
            }
        }
        return true;
    }
}
