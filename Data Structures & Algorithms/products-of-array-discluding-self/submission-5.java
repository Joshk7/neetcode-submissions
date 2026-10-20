class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int zeros = 0;
        int total = 1;
        for (int num : nums) {
            if (num == 0) {
                zeros++;
            } else {
                total *= num;
            }
        }

        if (zeros > 1) {
            return new int[n];
        }

        int[] output = new int[n];
        for (int i = 0; i < n; i++) {
            if (zeros > 0) {
                output[i] = (nums[i] == 0) ? total : 0;
            } else {
                output[i] = total / nums[i];
            }
        }

        return output;
    }
}  
