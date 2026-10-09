class Solution {
    private List<List<Integer>> ans;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        ans = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(new ArrayList<>(), 0, candidates, target);
        return ans;
    }

    private void backtrack(List<Integer> cur, int i, int[] candidates, int target) {
        if (target == 0) {
            ans.add(new ArrayList<>(cur));
            return;
        }

        if (i >= candidates.length || target < 0) {
            return;
        }

        cur.add(candidates[i]);
        backtrack(cur, i + 1, candidates, target - candidates[i]);
        cur.remove(cur.size() - 1);

        while (i + 1 < candidates.length && candidates[i] == candidates[i + 1]) {
            i++;
        }

        backtrack(cur, i + 1, candidates, target);
        
    }
}
