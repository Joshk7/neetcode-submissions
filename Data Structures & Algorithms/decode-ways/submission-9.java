class Solution {
    private int[] dp;

    public int numDecodings(String s) {
        int n = s.length();
        dp = new int[n + 2];
        dp[n] = 1;
        dp[n + 1] = 1;
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == '0') continue;
            dp[i] = dp[i + 1];
            if (i + 1 < n) {
                int twoDigit = (s.charAt(i) - '0') * 10 + (s.charAt(i + 1) - '0');
                if (twoDigit >= 10 && twoDigit <= 26) {
                    dp[i] += dp[i + 2];
                }
            }
        }

        return dp[0];
    }
}
