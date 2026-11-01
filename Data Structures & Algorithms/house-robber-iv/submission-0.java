class Solution {
    public int minCapability(int[] nums, int k) {
        int low = Arrays.stream(nums).min().orElse(0);
        int high = Arrays.stream(nums).max().orElse(0);

        while (low < high) {
            int mid = low + (high - low) / 2;

            int count = 0;
            int i = 0;
            while (i < nums.length) {
                if (nums[i] <= mid) {
                    count++;
                    i += 2;
                } else {
                    i++;
                }

                if (count >= k) break;
            }

            if (count >= k) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }
}
