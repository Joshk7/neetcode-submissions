class Node {
    Map<Character, Node> children = new HashMap<>();
    boolean ending;
}

class WordDictionary {

    private Node root;

    public WordDictionary() {
        root = new Node();
    }

    public void addWord(String word) {
        Node node = root;
        for (char c : word.toCharArray()) {
            if (!node.children.containsKey(c)) {
                node.children.put(c, new Node());
            }
            node = node.children.get(c);
        } 
        node.ending = true;
    }

    public boolean search(String word) {
        return dfs(word, root);
    }

    private boolean dfs(String word, Node node) {
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c == '.') {
                if (node.children.isEmpty()) {
                    return false;
                }

                for (Node nei : node.children.values()) {
                    if (dfs(word.substring(i + 1, word.length()), nei)) {
                        return true;
                    }
                }

                return false;
            } else if (!node.children.containsKey(c)) {
                return false;
            } else {
                node = node.children.get(c);
            }
        }
        return node.ending;
    }
}
