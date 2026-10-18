class Solution {
    public String[] wordSubsets(String[] words1, String[] words2) {
        Map<Character, Integer> letters = new HashMap<>();
        for (String word : words2) {
            Map<Character, Integer> current = new HashMap<>();
            for (char c : word.toCharArray()) {
                current.put(c, current.getOrDefault(c, 0) + 1);
                letters.put(c, Math.max(letters.getOrDefault(c, 0), current.get(c)));
            }
        }

        List<String> list = new ArrayList<>();

        for (String word : words1) {
            int passing = 0;
            Map<Character, Integer> current = new HashMap<>();
            for (char c : word.toCharArray()) {
                current.put(c, current.getOrDefault(c, 0) + 1);
                if (letters.containsKey(c) && current.get(c) == letters.get(c)) passing++;
                if (passing == letters.size()) {
                    list.add(word);
                    break;
                }
            }
        }

        String[] ans = new String[list.size()];
        int index = 0;
        for (String word : list) {
            ans[index++] = word;
        }
        return ans;
    }
}
