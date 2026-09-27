class Solution {
    public int findLucky(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int prev = i, num = arr[i];
            while (0 < num && num <= n) {
                int nxt = arr[num - 1];
                arr[num - 1] = Math.min(0, arr[num - 1]) - 1;
                if (num - 1 <= i || num - 1 == prev) break;
                prev = num - 1;
                num = nxt;
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            if (-arr[i] == i + 1) return i + 1;
        }

        return -1;
    }
}