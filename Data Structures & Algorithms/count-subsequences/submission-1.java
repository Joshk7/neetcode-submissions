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
        int ROWS = s.length();
        int COLS = t.length();
        int[][] memo = new int[ROWS + 1][COLS + 1];
        for (int r = 0; r < ROWS + 1; r++) {
            memo[r][COLS] = 1;
        }

        for (int r = ROWS - 1; r >= 0; r--) {
            for (int c = COLS - 1; c >= 0; c--) {
                memo[r][c] = memo[r + 1][c];
                if (s.charAt(r) == t.charAt(c)) {
                    memo[r][c] += memo[r + 1][c + 1];
                }
            }
        }

        return memo[0][0];
    }
}
