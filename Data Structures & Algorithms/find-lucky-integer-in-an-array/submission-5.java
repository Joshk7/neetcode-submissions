class Solution {
    public int findLucky(int[] arr) {
        Arrays.sort(arr);
        int prev = arr[arr.length - 1];
        int prevCount = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == prev) {
                prevCount++;
            } else {
                if (prev == prevCount) {
                    return prev;
                }
                prev = arr[i];
                prevCount = 1;
            }
        }

        return prev == prevCount ? prev : -1;
    }
}