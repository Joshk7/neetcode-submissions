class Solution {
    private Map<Character, Set<Character>> graph;
    private Map<Character, Boolean> visited;
    private List<Character> result;

    public String foreignDictionary(String[] words) {
        graph = new HashMap<>();
        for (String word : words) {
            for (char c : word.toCharArray()) {
                graph.putIfAbsent(c, new HashSet<>());
            }
        }

        int n = words.length;
        for (int i = 1; i < n; i++) {
            String w1 = words[i - 1], w2 = words[i];
            int minLen = Math.min(w1.length(), w2.length());
            if (
                w1.length() > w2.length() && 
                w1.substring(0, minLen).equals(w2.substring(0, minLen))
            ) {
                return "";
            } 
            for (int j = 0; j < minLen; j++) {
                if (w1.charAt(j) != w2.charAt(j)) {
                    graph.get(w1.charAt(j)).add(w2.charAt(j));
                    break;
                }
            }
        }

        visited = new HashMap<>();
        result = new ArrayList<>();
        for (char c : graph.keySet()) {
            if (dfs(c)) {
                return "";
            }
        }

        Collections.reverse(result);
        StringBuilder sb = new StringBuilder();
        for (char c : result) {
            sb.append(c);
        }

        return sb.toString();
    }

    private boolean dfs(char c) {
        if (visited.containsKey(c)) {
            return visited.get(c);
        }

        visited.put(c, true);
        for (char next : graph.get(c)) {
            if (dfs(next)) {
                return true;
            }
        }

        visited.put(c, false);
        result.add(c);
        return false;
    }
}
