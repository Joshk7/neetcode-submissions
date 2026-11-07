class Solution {
    private void mergeSort(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return;
        }

        int[] left = Arrays.copyOfRange(nums, 0, n / 2);
        int[] right = Arrays.copyOfRange(nums, n / 2, n);
        mergeSort(left);
        mergeSort(right);
        merge(left, right, nums);
        return;
    }

    private void merge(int[] left, int[] right, int[] nums) {
        int m = left.length;
        int n = right.length;
        int l = 0;
        int r = 0;
        while (l < m || r < n) {
            if (l == m) {
                nums[l + r] = right[r++];
                continue;
            }

            if (r == n) {
                nums[l + r] = left[l++];
                continue;
            }

            if (r == n || left[l] < right[r]) {
                nums[l + r] = left[l++];
            } else {
                nums[l + r] = right[r++];
            }
        }
    }

    public int[] sortArray(int[] nums) {
        mergeSort(nums);
        return nums;
    }
}