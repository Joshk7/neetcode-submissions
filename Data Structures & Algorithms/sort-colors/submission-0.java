class Solution {
    public void sortColors(int[] nums) {
        int[] colors = new int[3];
        for (int color : nums) {
            colors[color]++;
        }

        int n = nums.length;
        int index = 0;
        for (int color = 0; color < 3; color++) {
            while (colors[color]-- > 0) {
                nums[index++] = color;
            }
        }
    }
}