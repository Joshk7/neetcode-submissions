class Solution {
    public int numIdenticalPairs(int[] nums) {
        Map<Integer, Integer> pairs = new HashMap<>();
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            ans += pairs.getOrDefault(nums[i], 0);
            pairs.put(nums[i], pairs.getOrDefault(nums[i], 0) + 1);
        }
        return ans;
    }
}