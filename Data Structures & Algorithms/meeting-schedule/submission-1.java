/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
        if (intervals.isEmpty()) {
            return true;
        }
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval a, Interval b) {
                return a.start - b.start;
            }
        });

        int lastEnd = intervals.get(0).end;

        for (int i = 1; i < intervals.size(); i++) {
            if (lastEnd > intervals.get(i).start) {
                return false;
            }
            lastEnd = intervals.get(i).end;
        }

        return true;
    }
}
