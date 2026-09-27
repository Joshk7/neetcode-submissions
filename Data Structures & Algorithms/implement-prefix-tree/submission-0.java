class Node {
    public Map<Character, Node> children;
    public boolean ending;

    public Node() {
        children = new HashMap<>();
        ending = false;
    }
}

class PrefixTree {

    private Node root;

    public PrefixTree() {
        root = new Node();
    }

    public void insert(String word) {
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
        Node node = root;
        for (char c : word.toCharArray()) {
            if (!node.children.containsKey(c)) {
                return false;
            }
            node = node.children.get(c);
        }
        return node.ending;
    }

    public boolean startsWith(String prefix) {
        Node node = root;
        for (char c : prefix.toCharArray()) {
            if (!node.children.containsKey(c)) {
                return false;
            }
            node = node.children.get(c);
        }
        return true;
    }
}
