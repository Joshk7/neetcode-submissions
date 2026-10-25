class Solution {
    private int n;
    private Map<String, Integer> dp;
    private int[] nums;
    private int target;

    public int findTargetSumWays(int[] nums, int target) {
        this.n = nums.length;
        this.dp = new HashMap<>();
        this.nums = nums;
        this.target = target;
        return backtrack(0, 0);
    }

    private int backtrack(int i, int amount) {
        if (i == n) {
            return amount == target ? 1 : 0;
        }

        if (dp.containsKey(i + "," + amount)) return dp.get(i + "," + amount);
        int add = backtrack(i + 1, amount + nums[i]);
        int subtract = backtrack(i + 1, amount - nums[i]);
        dp.put(i + "," + amount, add + subtract);
        return dp.get(i + "," + amount);
    }
}
