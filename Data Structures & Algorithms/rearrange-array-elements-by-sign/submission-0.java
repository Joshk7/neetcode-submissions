class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int pos = 0;
        int neg = 1;
        int[] ans = new int[n];
        for (int num : nums) {
            if (num < 0) {
                ans[neg] = num;
                neg += 2;
            } else {
                ans[pos] = num;
                pos += 2;
            }
        }
        return ans;
    }
}