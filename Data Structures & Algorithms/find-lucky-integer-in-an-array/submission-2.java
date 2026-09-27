class Solution {
    public int findLucky(int[] arr) {
        int[] counts = new int[501];
        for (int num : arr) {
            counts[num]++;
        }

        for (int i = 500; i >= 1; i--) {
            if (i == counts[i]) {
                return i;
            }
        }

        return -1;
    }
}