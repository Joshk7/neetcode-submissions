class Solution {
    private String s;
    private String t;
    private int[][] memo;
    
    private int backtrack(int i, int j) {
        if (j == t.length()) return 1;
        if (i == s.length()) return 0;
        if (memo[i][j] != -1) return memo[i][j];

        int result = backtrack(i + 1, j);
        if (s.charAt(i) == t.charAt(j)) {
            result += backtrack(i + 1, j + 1);
        }

        memo[i][j] = result;
        return memo[i][j];
    }
    
    public int numDistinct(String s, String t) {
        this.s = s;
        this.t = t;
        memo = new int[s.length()][t.length()];
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < t.length(); j++) {
                memo[i][j] = -1;
            }
        }
        return backtrack(0, 0);
    }
}
