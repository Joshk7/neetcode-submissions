class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            int cmp = Integer.compare(a[0], b[0]);
            return cmp != 0 ? cmp : Integer.compare(b[1], a[1]);
        });

        int end = -1, answer = 0;
        for (int[] pair : intervals) {
            if (pair[1] > end) {
                answer++;
                end = pair[1];
            }
        }

        return answer;
    }
}
