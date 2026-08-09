class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] c1 = new int[26];
        for (char c : s1.toCharArray()) {
            int key = c - 'a';
            c1[key]++;
        }

        int k = s1.length();

        int[] c2 = new int[26];
        int l = 0;
        for (int r = 0; r < s2.length(); r++) {
            int keyR = s2.charAt(r) - 'a';
            c2[keyR]++;
            if (r - l + 1 > k) {
                int keyL = s2.charAt(l) - 'a';
                c2[keyL]--;
                l++;
            }
            
            if (isEqual(c1, c2)) {
                return true;
            }
        }

        return false;
    }

    private boolean isEqual(int[] one, int[] two) {
        for (int i = 0; i < 26; i++) {
            if (one[i] != two[i]) {
                return false;
            }
        }
        return true;
    }
}
