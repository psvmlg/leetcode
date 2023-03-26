import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRooms2 {

    public int minMeetingRooms(int[][] intervals) {
        if (intervals.length == 1) {
            return 1;
        }
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        PriorityQueue<Interval> queue = new PriorityQueue<Interval>((a, b) -> a.end - b.end);

        queue.add(new Interval(intervals[0][0], intervals[0][1]));

        for (int i = 1; i < intervals.length; i++) {
            int[] currentElem = intervals[i];
            Interval nextEndingEvent = queue.poll();

            if (nextEndingEvent.end <= currentElem[0]) {
                nextEndingEvent.end = currentElem[1];
            } else {
                queue.add(new Interval(currentElem[0], currentElem[1]));
            }
            queue.add(nextEndingEvent);
        }

        return queue.size();
    }

    class Interval {
        int start;
        int end;
        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
