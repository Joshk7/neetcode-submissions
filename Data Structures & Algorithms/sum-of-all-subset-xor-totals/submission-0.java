class Solution {
    private int ans = 0;

    public int subsetXORSum(int[] nums) {
        backtrack(0, nums, new ArrayList<>());
        return ans;
    }

    private void backtrack(int i, int[] nums, List<Integer> subset) {
        // if (i == nums.length) {
        //     ans ^= cur;
        //     return;
        // }

        // backtrack(i + 1, cur, nums);
        // backtrack(i + 1, cur ^ nums[i], nums);

        int xorr = 0;
        for (int num : subset) xorr ^= num;
        ans += xorr;

        for (int j = i; j < nums.length; j++) {
            subset.add(nums[j]);
            backtrack(j + 1, nums, subset);
            subset.remove(subset.size() - 1);
        }
    }
}