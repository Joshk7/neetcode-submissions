class Solution {
    private int[] dp;

    public int numDecodings(String s) {
        int n = s.length();
        dp = new int[n + 1];
        // Set the base case for when we reach the end of the string
        dp[n] = 1;
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                dp[i] = 0;
                continue;
            }

            // Path for single digits
            int ways = dp[i + 1];
            if (i + 1 < n) {
                char firstDigit = s.charAt(i);
                char secondDigit = s.charAt(i + 1);
                if (
                    (firstDigit == '1' && "0123456789".indexOf(secondDigit) != -1) ||
                    (firstDigit == '2' && "0123456".indexOf(secondDigit) != -1)
                ) {
                    // Path for double digits
                    ways += dp[i + 2];
                }
            }

            dp[i] = ways;
        }
        return dp[0];
    }

    private int backtrack(int i, String s) {
        if (i == s.length()) {
            return 1;
        }

        if (s.charAt(i) == '0') {
            return 0;
        }

        if (dp[i] != -1) {
            return dp[i];
        }

        // Path for single digit
        int ways = backtrack(i + 1, s);
        if (i + 1 < s.length()) {
            char firstDigit = s.charAt(i);
            char secondDigit = s.charAt(i + 1);
            if (
                (firstDigit == '1' && "0123456789".indexOf(secondDigit) != -1) ||
                (firstDigit == '2' && "0123456".indexOf(secondDigit) != -1)
            ) {
                // Path for double digits
                ways += backtrack(i + 2, s);
            }
        }
        dp[i] = ways;
        return dp[i];
    }
}
