class Solution {
    public int findLucky(int[] arr) {
        Arrays.sort(arr);
        int streak = 0;
        
        for (int i = arr.length - 1; i >= 0; i--) {
            streak++;
            if (i == 0 || arr[i] != arr[i - 1]) {
                if (arr[i] == streak) {
                    return arr[i];
                }
                streak = 0;
            }
        }

        return -1;
    }
}