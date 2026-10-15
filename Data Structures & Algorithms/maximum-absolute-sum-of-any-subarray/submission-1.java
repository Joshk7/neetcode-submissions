class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int ans = 0;
        int pos = 0;
        int neg = 0;
        for (int num : nums) {
            pos += num;
            neg += num;

            if (pos < 0) {
                pos = 0;
            }

            if (neg > 0) {
                neg = 0;
            }

            int cur = Math.max(Math.abs(neg), pos);
            ans = Math.max(ans, cur);
        }

        return ans;
    }
}
