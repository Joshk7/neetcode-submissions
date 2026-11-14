class Solution {
    public int subarraySum(int[] nums, int k) {
        int ans = 0, cur = 0, n = nums.length;
        Map<Integer, Integer> freqs = new HashMap<>();
        freqs.put(0, 1);
        for (int num : nums) {
            cur += num;
            ans += freqs.getOrDefault(cur - k, 0);
            freqs.put(cur, freqs.getOrDefault(cur, 0) + 1);
        }
        return ans;
    }
}