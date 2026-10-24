class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>();
        for (String word : wordDict) {
            set.add(word);
        }

        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                String word = s.substring(i, j + 1);
                if (!set.contains(word)) continue;
                if (dp[i] == true) {
                    dp[j + 1] = dp[i];
                }
            }
        }

        System.out.println(Arrays.toString(dp));

        return dp[n];
    }
}
