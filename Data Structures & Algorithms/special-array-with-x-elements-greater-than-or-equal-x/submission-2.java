class Solution {
    public int specialArray(int[] nums) {
        int n = nums.length;
        int l = 1;
        int r = n;
        while (l <= r) {
            int m = l + (r - l) / 2;
            int c = 0;
            for (int num : nums) {
                if (num >= m) {
                    c++;
                }
            }

            if (c == m) {
                return m;
            }

            if (c < m) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return -1;
    }
}