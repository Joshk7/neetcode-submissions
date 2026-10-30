class Solution {
    public long maxAlternatingSum(int[] nums) {
        long even = 0, odd = 0;
        for (int x : nums) {
            long nextEven = Math.max(even, odd + x);
            long nextOdd = Math.max(odd, even - x);
            even = nextEven; odd = nextOdd;
        }
        return even;
    }
}
