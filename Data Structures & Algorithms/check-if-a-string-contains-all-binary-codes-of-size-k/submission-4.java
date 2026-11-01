class Solution {
    public boolean hasAllCodes(String s, int k) {
        int n = s.length();
        if (n < (1 << k)) {
            return false;
        }

        boolean[] codeSet = new boolean[1 << k];
        int cur = 0, have = 0;

        for (int i = 0; i < n; i++) {
            cur = ((cur << 1) & ((1 << k) - 1)) | (s.charAt(i) - '0');

            if (i >= k - 1) {
                if (!codeSet[cur]) {
                    codeSet[cur] = true;
                    have++;
                }
            }
        }

        return have == (1 << k);
    }
}
