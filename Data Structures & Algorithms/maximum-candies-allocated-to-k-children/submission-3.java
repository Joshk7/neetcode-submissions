class Solution {
    public int maximumCandies(int[] candies, long k) {
        int low = 1;
        int high = 0;
        for (int candy : candies) {
            high = Math.max(high, candy);
        }

        int ans = 0;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (distribute(candies, k, mid)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }

    private boolean distribute(int[] candies, long k, int amount) {
        if (amount == 0) {
            return false;
        }

        long children = 0;
        for (int candy : candies) {
            children += (candy / amount);
        }
        return children >= k;
    }
}
