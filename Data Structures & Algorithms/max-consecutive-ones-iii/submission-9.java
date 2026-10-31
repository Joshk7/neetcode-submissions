class Solution {
    public int longestOnes(int[] nums, int k) {
        int res = 0;
        for (int l = 0; l < nums.length; l++) {
            int cnt = 0, r = l;
            while (r < nums.length) {
                if (nums[r] == 0) {
                    if (cnt == k) break;
                    cnt++;
                }
                r++;
            }
            res = Math.max(res, r - l);
        }
        return res;
    }
}