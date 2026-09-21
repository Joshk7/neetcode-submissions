class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');
        int[] res = new int[queries.length];

        for (int k = 0; k < queries.length; k++) {
            int start = queries[k][0], end = queries[k][1], count = 0;

            for (int i = start; i <= end; i++) {
                String word = words[i];
                if (
                    vowels.contains(word.charAt(0)) &&
                    vowels.contains(word.charAt(word.length() - 1))
                ) {
                    count++;
                }
                
                res[k] = count;
            }
        }

        return res;
    }
}