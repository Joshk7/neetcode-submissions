class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int one = 0;
        int two = 0;
        for (int i = 0; i < n; i++) {
            int tmp = Math.max(one + nums[i], two);
            one = two;
            two = tmp;
        }
        return two;
    }
}
