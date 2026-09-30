class Solution {
    private List<List<Integer>> ans;

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        ans = new ArrayList<>();
        backtrack(new ArrayList<>(), 0, 0, nums, target);
        return ans;
    }

    private void backtrack(List<Integer> cur, int sum, int i, int[] nums, int target) {
        if (i == nums.length) {
            return;
        }

        if (sum > target) {
            return;
        }

        if (sum == target) {
            ans.add(new ArrayList<>(cur));
            return;
        }

        cur.add(nums[i]);
        backtrack(cur, sum + nums[i], i, nums, target);
        cur.remove(cur.size() - 1);
        backtrack(cur, sum, i + 1, nums, target);
    }
}
