class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int[] prefix = new int[n + 1];
        int[] suffix = new int[n + 1];

        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + cardPoints[i];
        }

        for (int i = n - 1; i >= 0; i--) {
            suffix[i] = suffix[i + 1] + cardPoints[i];
        }

        int ans = 0;
        for (int left = 0; left <= k; left++) {
            int right = k - left;
            int total = prefix[left] + suffix[n - right];
            ans = Math.max(ans, total);
        }

        return ans;
    }
}