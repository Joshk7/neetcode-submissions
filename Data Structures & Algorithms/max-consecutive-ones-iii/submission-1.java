class Solution {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int res = 0;
        for (int l = 0; l < n; l++) {
            int cnt = 0;
            int r = l;
            while (r < n) {
                if (nums[r] == 0 && cnt == k) break;
                if (nums[r] == 0) cnt++;
                r++;
            }
            res = Math.max(res, r - l);
        }
        return res;
    }
}