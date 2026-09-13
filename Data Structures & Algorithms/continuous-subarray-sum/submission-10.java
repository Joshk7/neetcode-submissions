class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int r = 0;
        for (int i = 0; i < n; i++) {
            r = (r + nums[i]) % k;
            if (!map.containsKey(r)) {
                map.put(r, i);
            } else if (i - map.get(r) > 1) {
                return true;
            }
        }

        return false;
    }
}