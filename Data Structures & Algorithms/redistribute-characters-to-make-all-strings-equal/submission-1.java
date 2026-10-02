class Solution {
    public boolean makeEqual(String[] words) {
        int n = words.length;
        int[] count = new int[26];
        for (String word : words) {
            for (char letter : word.toCharArray()) {
                count[letter - 'a']++;
            }
        }

        for (int value = 0; value < 26; value++) {
            if (count[value] % n != 0) {
                return false;
            }
        }

        return true;
    }
}