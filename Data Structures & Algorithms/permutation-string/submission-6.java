class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        int[] c1 = new int[26];
        int[] c2 = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            c1[s1.charAt(i) - 'a']++;
            c2[s2.charAt(i) - 'a']++;
        }

        int matches = 0;
        for (int i = 0; i < 26; i++) { 
            if (c1[i] == c2[i]) {
                matches++;
            }
        }

        int l = 0;
        for (int r = s1.length(); r < s2.length(); r++) {
            if (matches == 26) {
                return true;
            }

            int index = s2.charAt(r) - 'a';
            c2[index]++;
            if (c1[index] == c2[index]) {
                matches++;
            } else if (c1[index] + 1 == c2[index]) {
                matches--;
            }

            index = s2.charAt(l) - 'a';
            c2[index]--;
            if (c1[index] == c2[index]) {
                matches++;
            } else if (c1[index] - 1 == c2[index]) {
                matches--;
            }
            l++;
        }
        return matches == 26;
    }
}
