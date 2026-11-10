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

    Node head;
    Node tail;
    Map<Integer, Node> map;
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
        map = new HashMap<>();
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }

        Node old = map.get(key);
        int value = old.value;
        Node node = new Node(key, value);
        delete(old);
        insert(node);

        map.put(key, node);
        return value;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node old = map.get(key);
            delete(old);
        }

        Node node = new Node(key, value);
        insert(node);

        map.put(key, node);
        if (map.size() > capacity) {
            Node evicted = head.next;
            delete(evicted);
            map.remove(evicted.key);
        }
    }

    // Inserts node in dll
    private void insert(Node node) {
        node.prev = tail.prev;
        tail.prev.next = node;
        node.next = tail;
        tail.prev = node;
    }

    // Deletes node from dll
    private void delete(Node node) {
        Node left = node.prev;
        Node right = node.next;
        left.next = right;
        right.prev = left;
    }
}
