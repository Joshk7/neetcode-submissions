class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int largest = 0;
        Stack<int[]> stack = new Stack<>(); // (index, height)

        for (int i = 0; i < n; i++) {
            int h = heights[i];
            int start = i;
            while (!stack.isEmpty() && stack.peek()[1] > h) {
                int[] top = stack.pop();
                int index = top[0];
                int height = top[1];
                largest = Math.max(largest, height * (i - index));
                start = index;
            }
            stack.push(new int[]{start, h});
        }

        while (!stack.isEmpty()) {
            int[] top = stack.pop();
            int index = top[0];
            int height = top[1];
            largest = Math.max(largest, height * (n - index));
        }

        return largest;
    }
}
