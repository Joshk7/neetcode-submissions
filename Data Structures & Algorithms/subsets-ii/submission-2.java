class Solution {
    private List<List<Integer>> ans;
    private int[] nums;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        int n = nums.length;
        this.nums = nums;
        ans = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(new ArrayList<>(), 0, n);
        return ans;
    }

    private void backtrack(List<Integer> curr, int i, int n) {
        ans.add(new ArrayList<>(curr));

        for (int j = i; j < n; j++) {
            if (j > i && nums[j] == nums[j - 1]) {
                continue;
            }
            curr.add(nums[j]);
            backtrack(curr, j + 1, n);
            curr.remove(curr.size() - 1);
        }
        return;
    }
}
