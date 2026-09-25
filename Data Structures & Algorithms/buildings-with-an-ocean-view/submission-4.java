class Solution {
    public int[] findBuildings(int[] heights) {
        List<Integer> res = new ArrayList<>();
        int n = heights.length;
        res.add(n - 1);

        for (int i = n - 2; i >= 0; i--) {
            if (heights[i] > heights[res.get(res.size() - 1)]) {
                res.add(i);
            }
        }

        Collections.reverse(res);
        int[] ans = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            ans[i] = res.get(i);
        }
        return ans;
    }
}