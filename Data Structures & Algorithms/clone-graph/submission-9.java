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
    public Node cloneGraph(Node node) {
        Map<Node, Node> map = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        q.offer(node);
        while (!q.isEmpty()) {
            Node n = q.poll();
            if (n == null) {
                continue;
            }

            if (!map.containsKey(n)) {
                Node copy = new Node(n.val);
                map.put(n, copy);
            }

            for (Node neighbor : n.neighbors) {
                if (!map.containsKey(neighbor)) {
                    Node newNeighbor = new Node(neighbor.val);
                    map.put(neighbor, newNeighbor);
                    q.offer(neighbor);
                }

                map.get(n).neighbors.add(map.get(neighbor));
            }
        }

        return map.get(node);
    }

    private Node clone(Node node, Map<Node, Node> map) {
        if (node == null) {
            return null;
        }

        if (map.containsKey(node)) {
            return map.get(node);
        }

        Node copy = new Node(node.val);
        map.put(node, copy);
        for (Node neighbor : node.neighbors) {
            copy.neighbors.add(clone(neighbor, map));
        }

        return copy;
    }
}