class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int m = flowerbed.length;
        int[] flowers = new int[m + 2];
        for (int i = 0; i < m; i++) {
            flowers[i + 1] = flowerbed[i];
        }

        int count = 0;
        for (int i = 1; i < m + 1; i++) {
            if (flowers[i - 1] == 0 && flowers[i] == 0 && flowers[i + 1] == 0) {
                count++;
                flowers[i] = 1;
            }
        }

        return n <= count;
    }
}