class Solution {
    private int[][] cache;
    private String word1;
    private String word2;
    private int m;
    private int n;

    public int minDistance(String word1, String word2) {
        this.word1 = word1;
        this.word2 = word2;
        m = word1.length();
        n = word2.length();
        cache = new int[m + 1][n + 1];
        for (int[] row : cache) {
            Arrays.fill(row, -1);
        }
        return dfs(0, 0);
    }

    private int dfs(int i, int j) {
        if (i >= m) {
            cache[i][j] = n - j;
            return cache[i][j];
        }

        if (j >= n) {
            cache[i][j] = m - i;
            return cache[i][j];
        }

        if (cache[i][j] != -1) {
            return cache[i][j];
        }

        if (word1.charAt(i) == word2.charAt(j)) {
            cache[i][j] = dfs(i + 1, j + 1);
            return cache[i][j];
        }

        int insert = 1 + dfs(i + 1, j);
        int delete = 1 + dfs(i, j + 1);
        int replace = 1 + dfs(i + 1, j + 1);
        int result = Math.min(Math.min(insert, delete), replace);
        cache[i][j] = result;
        return cache[i][j];
    }
}
