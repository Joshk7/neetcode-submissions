class Solution {
    private List<List<Integer>> ans;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        ans = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(new ArrayList<>(), 0, nums);
        return ans;
    }

    private void backtrack(List<Integer> cur, int i, int[] nums) {
        if (i == nums.length) {
            ans.add(new ArrayList<>(cur));
            return;
        }

        cur.add(nums[i]);
        backtrack(cur, i + 1, nums);
        cur.remove(cur.size() - 1);

        while (i + 1 < nums.length && nums[i] == nums[i + 1]) {
            i++;
        }
        backtrack(cur, i + 1, nums);
    }
}
