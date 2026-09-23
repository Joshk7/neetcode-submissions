/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}
*/

class Solution {
    public Node connect(Node root) {
        Map<Integer, Node> map = new HashMap<>();
        dfs(root, 0, map);
        return root;
    }

    private void dfs(Node node, int depth, Map<Integer, Node> map) {
        if (node == null) {
            return;
        }

        if (!map.containsKey(depth)) {
            map.put(depth, node);
        } else {
            map.get(depth).next = node;
            map.put(depth, node);
        }

        dfs(node.left, depth + 1, map);
        dfs(node.right, depth + 1, map);
    }
}