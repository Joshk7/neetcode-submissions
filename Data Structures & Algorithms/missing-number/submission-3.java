class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int mask = 0;
        for (int i = 0; i <= n; i++) {
            mask ^= i;
        }
        
        for (int num : nums) {
            mask ^= num;
        }
        return mask;
    }
}
