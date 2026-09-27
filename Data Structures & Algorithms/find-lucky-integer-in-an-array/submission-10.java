class Solution {
    public int findLucky(int[] arr) {
        for (int num : arr) {
            int idx = num & ((1 << 10) - 1);
            if (idx <= arr.length) {
                arr[idx - 1] += (1 << 10);
            }
        }

        for (int i = arr.length - 1; i >= 0; i--) {
            int cnt = arr[i] >> 10;
            if (cnt == i + 1) return i + 1;
        }

        return -1;
    }
}