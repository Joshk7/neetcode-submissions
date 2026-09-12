class Solution {
    private List<List<Integer>> ans;

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        ans = new ArrayList<>();
        Arrays.sort(nums);

        List<Integer> cur = new ArrayList<>();
        backtrack(nums, target, cur, 0, 0);
        return this.ans;
    }

    private void backtrack(int[] nums, int target, List<Integer> cur, int i, int sum) {
        if (sum > target) {
            return;
        }
        
        if (sum == target) {
            this.ans.add(new ArrayList<>(cur));
            return;
        }

        for (int j = i; j < nums.length; j++) {
            cur.add(nums[j]);
            backtrack(nums, target, cur, j, sum + nums[j]);
            cur.remove(cur.size() - 1);
        }
    }
}
