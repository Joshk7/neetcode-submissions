class Solution {
    public int[] findBuildings(int[] heights) {
        int n = heights.length;
        int max = heights[n - 1];
        Stack<Integer> stack = new Stack<>();
        stack.push(n - 1);
        for (int i = n - 2; i >= 0; i--) {
            int height = heights[i];
            if (height > max) {
                stack.push(i);
            }
            max = Math.max(max, height);
        }

        int m = stack.size();
        int[] ans = new int[m];
        for (int i = 0; i < m; i++) {
            ans[i] = stack.pop();
        }
        return ans;
    }
}