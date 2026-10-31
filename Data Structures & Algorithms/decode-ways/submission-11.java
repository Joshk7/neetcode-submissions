class Solution {
    private int[] dp;

    public int numDecodings(String s) {
        dp = new int[s.length()];
        Arrays.fill(dp, -1);
        return backtrack(0, s);
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
