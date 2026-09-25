class Solution {
    public int[] findBuildings(int[] heights) {
        int n = heights.length;
        List<Integer> oceanView = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            boolean tallest = true;
            for (int j = i + 1; j < n; j++) {
                if (heights[i] <= heights[j]) {
                    tallest = false;
                    break;
                }
            }
            if (tallest) {
                oceanView.add(i);
            }
        }

        int m = oceanView.size();
        int[] ans = new int[m];
        for (int i = 0; i < m; i++) {
            ans[i] = oceanView.get(i);
        }
        return ans;
    }
}