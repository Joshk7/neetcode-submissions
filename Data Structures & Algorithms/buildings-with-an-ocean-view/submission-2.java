class Solution {
    public int[] findBuildings(int[] heights) {
        int n = heights.length;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && heights[i] >= heights[stack.peek()]) {
                stack.pop();
            }
            stack.push(i);
        }

        int m = stack.size();
        int[] ans = new int[m];
        for (int i = m - 1; i >= 0; i--) {
            ans[i] = stack.pop();
        }
        return ans;
    }
}