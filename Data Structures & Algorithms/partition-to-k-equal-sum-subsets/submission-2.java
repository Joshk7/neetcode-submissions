class Solution {
    int n;
    int target;
    int[] nums;
    boolean[] used;

    public boolean canPartitionKSubsets(int[] nums, int k) {
        n = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if (sum % k != 0) {
            return false;
        }

        Arrays.sort(nums);
        for (int i = 0; i < n / 2; i++) {
            int tmp = nums[i];
            nums[i] = nums[n - i - 1];
            nums[n - i - 1] = tmp;
        }

        target = sum / k;
        used = new boolean[n];
        this.nums = nums;

        return backtrack(0, k, 0);
    }

    private boolean backtrack(int i, int k, int sum) {
        if (k == 0) {
            return true;
        }

        if (sum == target) {
            return backtrack(0, k - 1, 0);
        }

        for (int j = i; j < n; j++) {
            if (used[j] || sum + nums[j] > target) {
                continue;
            }

            used[j] = true;
            if(backtrack(j + 1, k, sum + nums[j])) return true;
            used[j] = false;
        }

        return false;
    }
}