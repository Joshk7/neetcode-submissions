class Solution {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int[] prefix = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + (nums[i] == 0 ? 1 : 0);
        }

        int res = 0;
        for (int l = 0; l < n; l++) {
            int r = binarySearch(prefix, l, n, k);
            res = Math.max(res, r - l);
        }

        return res;
    }

    private int binarySearch(int[] prefix, int targetL, int r, int k) {
        int l = targetL;
        while (l < r) {
            int m = (l + r) / 2;
            if (prefix[m + 1] - prefix[targetL] <= k) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return l;
    }
}