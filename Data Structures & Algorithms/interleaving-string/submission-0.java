class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length(), n = s2.length();
        if (s3.length() != m + n) {
            return false;
        }

        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[m][n] = true;

        for (int r = m; r >= 0; r--) {
            for (int c = n; c >= 0; c--) {
                if (r == m && c == n) continue;

                int k = r + c;
                if (r < m && s3.charAt(k) == s1.charAt(r) && dp[r + 1][c]) {
                    dp[r][c] = true;
                }

                if (c < n && s3.charAt(k) == s2.charAt(c) && dp[r][c + 1]) {
                    dp[r][c] = true;
                }
            }
        }

        return dp[0][0];
    }
}
