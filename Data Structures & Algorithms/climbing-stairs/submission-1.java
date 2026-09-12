class Solution {
    private Map<Integer, Integer> cache;

    public int climbStairs(int n) {
        this.cache = new HashMap<>();
        return climb(n);
    }

    private int climb(int n) {
        if (this.cache.containsKey(n)) {
            return this.cache.get(n);
        }

        if (n == 0) {
            return 1;
        }

        if (n == 1) {
            return 1;
        }

        int val = climb(n - 1) + climb(n - 2);
        this.cache.put(n, val);
        return val;
    }
}
