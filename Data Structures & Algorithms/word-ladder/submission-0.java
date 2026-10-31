class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Map<String, List<String>> graph = new HashMap<>();
        wordList.add(beginWord);
        int m = wordList.size();
        int n = beginWord.length();
        for (int i = 0; i < m; i++) {
            String word1 = wordList.get(i);
            graph.put(word1, new ArrayList());
            for (int j = 0; j < m; j++) {
                if (i == j) continue;
                String word2 = wordList.get(j);
                int diff = 0;
                for (int k = 0; k < n; k++) {
                    if (word1.charAt(k) != word2.charAt(k)) {
                        diff++;
                    }

                    if (diff > 1) {
                        break;
                    }
                }

                if (diff == 1) {
                    graph.get(word1).add(word2);
                }
            }
        }

        Set<String> seen = new HashSet<>();
        ArrayDeque<String> q = new ArrayDeque<>();
        q.offer(beginWord);
        seen.add(beginWord);
        int steps = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String word = q.poll();
                for (String nei : graph.get(word)) {
                    if (seen.contains(nei)) continue;
                    if (nei.equals(endWord)) {
                        return steps + 2;
                    };
                    seen.add(nei);
                    q.offer(nei);
                }
            }
            steps++;
        }

        return 0;
    }
}
