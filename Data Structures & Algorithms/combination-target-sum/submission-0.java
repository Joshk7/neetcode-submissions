class Solution {
    private List<List<Integer>> ans;

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        ans = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        backtrack(nums, target, cur, 0);
        return this.ans;
    }

    private void backtrack(int[] nums, int target, List<Integer> cur, int i) {
        if (target == 0) {
            ans.add(new ArrayList<>(cur));
            return;
        }

        if (target < 0 || i >= nums.length) {
            return;
        }

        cur.add(nums[i]);
        backtrack(nums, target - nums[i], cur, i);
        cur.remove(cur.size() - 1);
        backtrack(nums, target, cur, i + 1);
    }
}
