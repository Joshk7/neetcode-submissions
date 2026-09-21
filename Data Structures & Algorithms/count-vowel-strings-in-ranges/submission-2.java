class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int vowels = 0;
        for (char c : "aeiou".toCharArray()) {
            vowels |= 1 << (c - 'a');
        }

        int[] prefix = new int[words.length + 1];
        for (int i = 0; i < words.length; i++) {
            int f = words[i].charAt(0) - 'a';
            int l = words[i].charAt(words[i].length() - 1) - 'a';
            int isVowel = ((1 << f) & vowels) != 0 && ((1 << l) & vowels) != 0 ? 1 : 0;
            prefix[i + 1] = prefix[i] + isVowel;
        }

        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0], r = queries[i][1];
            res[i] = prefix[r + 1] - prefix[l];
        }

        return res;
    }
}