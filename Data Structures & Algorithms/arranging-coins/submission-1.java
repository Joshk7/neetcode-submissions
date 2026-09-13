class Solution {
    public int arrangeCoins(int n) {
        int row = 0;
        int coins = n;
        while (coins - row > 0) {
            row++;
            coins -= row;
        }

        return row;
    }
}