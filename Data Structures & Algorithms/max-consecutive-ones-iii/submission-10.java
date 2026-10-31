class Solution {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length; 
        int[] prefix = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + (nums[i] == 0 ? 1 : 0);
        }

        int res = 0;
        for (int l = 0; l < n; l++) {
            int low = l, high = n;
            while (low < high) {
                int mid = (low + high) / 2;
                if (prefix[mid + 1] - prefix[l] <= k) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }
            res = Math.max(res, low - l);
        }

        return res;
    }
}