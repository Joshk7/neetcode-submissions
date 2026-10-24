class TrieNode {
    public TrieNode[] children;
    public boolean ending;

    public TrieNode() {
        children = new TrieNode[26];
        ending = false;
    }
}

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        TrieNode root = new TrieNode();
        for (String word : wordDict) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                if (node.children[c - 'a'] == null) {
                    node.children[c - 'a'] = new TrieNode();
                }
                node = node.children[c - 'a'];
            }
            node.ending = true;
        }

        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int i = 0; i < n; i++) {
            TrieNode node = root;
            for (int j = i; j < n; j++) {
                char c = s.charAt(j);
                if (node.children[c - 'a'] == null) break; 
                node = node.children[c - 'a'];
                if (dp[i] == true && node.ending) {
                    dp[j + 1] = dp[i];
                }
            }
        }

        System.out.println(Arrays.toString(dp));

        return dp[n];
    }
}
