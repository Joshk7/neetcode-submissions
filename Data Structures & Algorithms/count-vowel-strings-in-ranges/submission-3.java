class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');
        int n = words.length;
        int[] prefix = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            String word = words[i - 1];
            if (
                vowels.contains(word.charAt(0)) && 
                vowels.contains(word.charAt(word.length() - 1))
            ) {
                prefix[i]++;
            }

            prefix[i] += prefix[i - 1];
        }

        int m = queries.length;
        int[] ans = new int[m];
        for (int i = 0; i < m; i++) {
            int[] query = queries[i];
            int start = query[0];
            int end = query[1];
            ans[i] = prefix[end + 1] - prefix[start];
        }
        return ans;
    }
}