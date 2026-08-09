/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();

        Node node = head;
        while (node != null) {
            map.put(node, new Node(node.val));
            node = node.next;
        }

        node = head;
        while (node != null) {
            Node copyNode = map.get(node);
            Node copyNext = node.next != null ? map.get(node.next) : null;
            Node copyRandom = node.random != null ? map.get(node.random) : null;
            copyNode.next = copyNext;
            copyNode.random = copyRandom;
            node = node.next;
        }

        return map.get(head);
    }
}
