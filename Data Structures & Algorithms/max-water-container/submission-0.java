class Solution {
    public int maxArea(int[] heights) {
        int largestArea = 0;
        int left = 0;
        int right = heights.length - 1;
        while (left < right) {
            int height = Math.min(heights[left], heights[right]);
            int width = right - left;
            int currentArea = height * width;
            largestArea = Math.max(largestArea, currentArea);
            if (heights[left] <= heights[right]) {
                left++;
            } else {
                right--;
            }
        }
        return largestArea;
    }
}
