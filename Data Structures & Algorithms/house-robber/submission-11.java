class Solution {
    public int rob(int[] nums) {
        int one = 0, two = 0;

        for (int num : nums) {
            int tmp = Math.max(num + one, two);
            one = two;
            two = tmp;
        }

        return two;
    }
}
