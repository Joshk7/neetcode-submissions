class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> remainder = new HashMap<>();
        remainder.put(0, -1);
        int r = 0;
        for (int i = 0; i < n; i++) {
            r = (r + nums[i]) % k;
            if (!remainder.containsKey(r)) {
                remainder.put(r, i);
            } else if (i - remainder.get(r) + 1 > 2) {
                return true;
            }
        }
        return false;
    }
}