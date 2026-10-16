class Solution {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int n = colors.length;
        int run = 1;
        int ans = 0;
        for (int i = 0; i < n + k - 1; i++) {
            if (i > 0 && colors[i % n] == colors[(i - 1) %n]) {
                run = 1;
            } else {
                run++;
            }

            if (i >= k - 1 && run >= k) {
                ans++;
            }
        }
        return ans;
    }
}
