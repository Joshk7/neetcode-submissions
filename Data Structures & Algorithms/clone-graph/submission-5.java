/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    private Map<Node, Node> graph = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }

        Node clone = new Node(node.val);
        graph.put(node, clone);
        for (Node neighbor : node.neighbors) {
            if (!graph.containsKey(neighbor)) {
                graph.put(neighbor, cloneGraph(neighbor));
            }
            clone.neighbors.add(graph.get(neighbor));
        }

        return clone;
    }
}