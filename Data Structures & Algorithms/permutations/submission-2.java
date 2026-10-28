class Solution {
    private int[] nums;
    private List<List<Integer>> ans;
    private boolean[] seen;
    private List<Integer> cur;

    public List<List<Integer>> permute(int[] nums) {
        this.nums = nums;
        this.ans = new ArrayList<>();
        this.seen = new boolean[nums.length];
        this.cur = new ArrayList<>();
        backtrack();
        return this.ans;
    }

    private void backtrack() {
        if (cur.size() == nums.length) {
            ans.add(new ArrayList<>(cur));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (seen[i]) continue;
            seen[i] = true;
            cur.add(nums[i]);
            backtrack();
            cur.remove(cur.size() - 1);
            seen[i] = false;
        }
        return;
    }
}
