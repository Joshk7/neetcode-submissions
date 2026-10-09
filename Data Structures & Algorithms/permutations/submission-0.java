class Solution {
    List<List<Integer>> ans;

    public List<List<Integer>> permute(int[] nums) {
        ans = new ArrayList<>();
        boolean[] seen = new boolean[nums.length];
        backtrack(seen, new ArrayList<>(), nums);
        return ans;
    }

    private void backtrack(boolean[] seen, List<Integer> cur, int[] nums) {
        if (cur.size() == nums.length) {
            ans.add(new ArrayList<>(cur));
        }

        for (int j = 0; j < nums.length; j++) {
            if (seen[j]) {
                continue;
            }

            cur.add(nums[j]);
            seen[j] = true;
            backtrack(seen, cur, nums);
            seen[j] = false;
            cur.remove(cur.size() - 1);
        }
    }
}
