class Solution {
    public boolean lemonadeChange(int[] bills) {
        int fives = 0;
        int tens = 0;

        for (int bill : bills) {
            if (bill == 20) {
                if (fives >= 3) {
                    fives -= 3;
                } else if (fives >= 1 && tens >= 1) {
                    fives--;
                    tens--;
                } else {
                    return false;
                }
            } else if (bill == 10) {
                if (fives >= 1) {
                    fives--;
                    tens++;
                } else {
                    return false;
                }
            } else {
                fives++;
            }
        }

        return true;
    }
}