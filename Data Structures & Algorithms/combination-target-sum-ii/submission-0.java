class Solution {
    private List<List<Integer>> ans;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        ans = new ArrayList<>();
        backtrack(new ArrayList<>(), 0, candidates, 0, target);
        return ans;
    }

    private void backtrack(List<Integer> cur, int i, int[] candidates, int total, int target) {
        if (target == total) {
            ans.add(new ArrayList<>(cur));
            return;
        }
        
        if (i >= candidates.length) {
            return;
        }

        if (total > target) {
            return;
        }


        cur.add(candidates[i]);
        backtrack(cur, i + 1, candidates, total + candidates[i], target);
        cur.remove(cur.size() - 1);
        
        while (i + 1 < candidates.length && candidates[i] == candidates[i + 1]) {
            i++;
        }
        backtrack(cur, i + 1, candidates, total, target);
    }
}
