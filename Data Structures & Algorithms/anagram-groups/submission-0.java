class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> answer = new ArrayList<>();
        Map<String, List<String>> groups = new HashMap<>();

        for (String str : strs) {
            char[] letters = str.toCharArray();
            Arrays.sort(letters);
            String key = new String(letters);
            if (!groups.containsKey(key)) {
                groups.put(key, new ArrayList<>());
            }
            groups.get(key).add(str);
        }

        for (List<String> group : groups.values()) {
            answer.add(group);
        }

        return answer;
    }
}
