class Solution {
    private String word1;
    private String word2;
    private int[][] memo;

    private int backtrack(int i, int j) {
        if (i == word1.length()) {
            memo[i][j] = word2.length() - j;
        }

        if (j == word2.length()) {
            memo[i][j] = word1.length() - i;
        }

        if (memo[i][j] != -1) {
            return memo[i][j];
        }

        int result = Math.min(1 + backtrack(i + 1, j), 1 + backtrack(i, j + 1));

        if (word1.charAt(i) == word2.charAt(j)) {
            result = Math.min(result, backtrack(i + 1, j + 1));
        } else {
            result = Math.min(result, 1 + backtrack(i + 1, j + 1));
        }

        memo[i][j] = result;
        return memo[i][j];
    }

    public int minDistance(String word1, String word2) {
        this.word1 = word1;
        this.word2 = word2;
        this.memo = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 0; i < word1.length() + 1; i++) {
            for (int j = 0; j < word2.length() + 1; j++) {
                memo[i][j] = -1;
            }
        }

        for (int i = 0; i < word1.length() + 1; i++) {
            for (int j = 0; j < word2.length() + 1; j++) {
                System.out.print(memo[i][j]);
            }
            System.out.println();
        }
        return backtrack(0, 0);
    }
}
