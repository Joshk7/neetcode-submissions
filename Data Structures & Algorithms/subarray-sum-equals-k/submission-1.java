class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length, ans = 0;
        int[] prefix = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = nums[i] + prefix[i];
        }

        Map<Integer, Integer> freqs = new HashMap<>();
        for (int p : prefix) {
            ans += freqs.getOrDefault(p - k, 0);
            freqs.put(p, freqs.getOrDefault(p, 0) + 1);
        }

        return ans;
    }
}