class Solution {
    public int trap(int[] height) {
        int rainWater = 0;
        int left = 0, right = height.length - 1;
        int maxLeft = Integer.MIN_VALUE, maxRight = Integer.MIN_VALUE;
        while (left < right) {
            if (height[left] < height[right]) {
                maxLeft = Math.max(maxLeft, height[left]);
                rainWater += maxLeft - height[left];
                left++;
            } else {
                maxRight = Math.max(maxRight, height[right]);
                rainWater += maxRight - height[right];
                right--;
            }
        }
        return rainWater;
    }
}
