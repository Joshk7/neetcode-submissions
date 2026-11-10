class Node {
    int key;
    int value;
    Node prev;
    Node next;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

class LRUCache {

    private Node head;
    private Node tail;
    private Map<Integer, Node> nodes;
    private int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
        nodes = new HashMap<>();
    }
    
    public int get(int key) {
        if (!nodes.containsKey(key)) {
            return -1;
        }

        Node old = nodes.get(key);
        Node node = new Node(key, old.value);
        remove(old);
        offer(node);
        nodes.put(key, node);
        return node.value;
    }
    
    public void put(int key, int value) {
        if (nodes.containsKey(key)) {
            Node old = nodes.get(key);
            remove(old);
        }

        Node node = new Node(key, value);
        offer(node);
        nodes.put(key, node);

        if (nodes.size() > capacity) {
            Node evicted = head.next;
            remove(evicted);
            nodes.remove(evicted.key);
        }
    }

    private void remove(Node node) {
        Node left = node.prev;
        Node right = node.next;
        left.next = right;
        right.prev = left;
    }

    private void offer(Node node) {
        node.prev = tail.prev;
        node.next = tail;
        node.prev.next = node;
        node.next.prev = node;
    }
}
