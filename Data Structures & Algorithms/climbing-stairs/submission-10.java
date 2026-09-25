class Solution {
    private int[] cache;

    public int climbStairs(int n) {
        cache = new int[n + 1];
        Arrays.fill(cache, -1);
        return dfs(n);
    }

    private int dfs(int n) {
        if (n == 0) {
            return 1;
        }

        if (n == 1) {
            return 1;
        }

        if (cache[n] != -1) {
            return cache[n];
        }

        int result = dfs(n - 1) + dfs(n - 2);
        cache[n] = result;
        return result;
    }
}
