class Solution {
    public int minCost(String colors, int[] neededTime) {
        int max = 0, ans = 0, n = colors.length();

        for (int i = 0; i < n; i++) {
            if (i == 0 || colors.charAt(i) != colors.charAt(i - 1)) {
                max = 0;
            }

            ans += Math.min(max, neededTime[i]);
            max = Math.max(max, neededTime[i]);
        }

        return ans;
    }
}
