class Solution {
    public int findLucky(int[] arr) {
        int[] counts = new int[501];
        for (int num : arr) {
            counts[num]++;
        }

        int ans = -1;
        for (int i = 1; i < 501; i++) {
            if (i == counts[i]) {
                ans = i;
            }
        }

        return ans;
    }
}