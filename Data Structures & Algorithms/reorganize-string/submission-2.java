class Solution {
    public String reorganizeString(String s) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        int maxIdx = 0;
        for (int i = 1; i < 26; i++) {
            if (freq[i] > freq[maxIdx]) {
                maxIdx = i;
            }
        }

        int maxFreq = freq[maxIdx];
        if (maxFreq > (s.length() + 1) / 2) {
            return "";
        }

        char[] res = new char[s.length()];
        int idx = 0;
        char maxChar = (char) (maxIdx + 'a');

        while (freq[maxIdx] > 0) {
            res[idx] = maxChar;
            idx += 2;
            freq[maxIdx]--;
        }

        for (int i = 0; i < 26; i++) {
            while (freq[i] > 0) {
                if (idx >= s.length()) {
                    idx = 1;
                }
                res[idx] = (char) (i + 'a');
                idx += 2;
                freq[i]--;
            }
        }

        return new String(res);
    }
}