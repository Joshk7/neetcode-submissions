class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = 1;
        for (int pile : piles) {
            high = Math.max(high, pile);
        }

        while (low < high) {
            int speed = low + (high - low) / 2;
            int hours = 0;
            for (int pile : piles) {
                hours += Math.ceil((double) pile / speed);
            }

            if (hours <= h) {
                high = speed;
            } else {
                low = speed + 1;
            }
        }

        return low;
    }
}
