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

/**
 * Definition of Interval:
 * public class Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

public class Solution {
    
    public int minMeetingRooms(List<Interval> intervals) {
        // Write your code here
        int n = intervals.size();

        int[] starts = new int[n];
        int[] ends = new int[n];
        for (int i = 0; i < n; i++) {
            Interval tmp = intervals.get(i);
            starts[i] = tmp.start;
            ends[i] = tmp.end;
        }

        Arrays.sort(starts);
        Arrays.sort(ends);

        int min = 0;
        int cur = 0;
        int s = 0;
        int e = 0;

        while (s < n) {
            if (starts[s] < ends[e]) {
                cur++;
                s++;
            } else {
                cur--;
                e++;
            }
            min = Math.max(min, cur);
        }

        return min;
    }
}
