class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int l = 0, window = 0, maxWindow = 0, satisfied = 0;

        for (int r = 0; r < customers.length; r++) {
            if (grumpy[r] == 1) {
                window += customers[r];
            } else {
                satisfied += customers[r];
            }

            if (r - l + 1 > minutes) {
                if (grumpy[l] == 1) {
                    window -= customers[l];
                }
                l++;
            }

            maxWindow = Math.max(window, maxWindow);
        }

        return satisfied + maxWindow;
    }
}