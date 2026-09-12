class Solution {
    public int climbStairs(int n) {
        int one = 0;
        int two = 1;
        for (int i = 0; i < n; i++) {
            int three = one + two;
            one = two;
            two = three;
        }

        return two;
    }
}
