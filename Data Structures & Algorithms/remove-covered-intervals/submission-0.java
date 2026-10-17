class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            int cmp = Integer.compare(a[0], b[0]);
            return cmp != 0 ? cmp : Integer.compare(b[1], a[1]);
        });

        int removals = 0;
        int n = intervals.length;
        int[] prev = intervals[0];
        
        for (int i = 1; i < n; i++) {
            int pl = prev[0];
            int pr = prev[1];
            int[] curr = intervals[i];
            int cl = curr[0];
            int cr = curr[1];
            if (pl <= cl && pr >= cr) {
                removals++;
            } else {
                prev = curr;
            }
        }

        return n - removals;
    }
}
