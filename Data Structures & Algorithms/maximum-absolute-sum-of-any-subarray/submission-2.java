class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int prefix = 0, low = 0, high = 0;
        for (int x : nums) {
            prefix += x;
            low = Math.min(low, prefix);
            high = Math.max(high, prefix);
        }
        return high - low;
    }
}
