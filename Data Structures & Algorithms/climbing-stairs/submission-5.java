class Solution {
    private Map<Integer, Integer> memo;

    public int climbStairs(int n) {
        this.memo = new HashMap<>();
        return backtrack(n);
    }

    private int backtrack(int n) {
        if (this.memo.containsKey(n)) {
            return this.memo.get(n);
        }

        if (n == 0) {
            return 1;
        }

        if (n == 1) {
            return 1;
        }

        int val = backtrack(n - 1) + backtrack(n - 2);
        this.memo.put(n, val);
        return val;
    }
}
