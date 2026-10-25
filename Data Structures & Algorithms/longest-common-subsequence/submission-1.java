class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();

        int[][] dp = new int[m + 1][n + 1];
        for (int r = m - 1; r >= 0; r--) {
            for (int c = n - 1; c >= 0; c--) {
                if (text1.charAt(r) == text2.charAt(c)) {
                    dp[r][c] = 1 + dp[r + 1][c + 1];
                } else {
                    dp[r][c] = Math.max(dp[r + 1][c], dp[r][c + 1]);
                }
            }
        }

        return dp[0][0];
    }
}
