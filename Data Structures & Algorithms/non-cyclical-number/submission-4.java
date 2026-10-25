class Solution {
    public boolean isHappy(int n) {
        Set<Integer> seen = new HashSet<>();
        int x = n;
        while (!seen.contains(x)) {
            if (x == 1) return true;
            seen.add(x);
            x = next(x);
        }

        return false;
    }

    private int next(int x) {
        int res = 0;
        while (x > 0) {
            int digit = x % 10;
            res += digit * digit;
            x /= 10;
        }
        return res;
    }
}
