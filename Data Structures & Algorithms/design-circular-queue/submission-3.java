class ListNode {
    int val;
    ListNode next;
    ListNode prev;

    public ListNode() {

    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public ListNode(int val, ListNode next, ListNode prev) {
        this.val = val;
        this.next = next;
        this.prev = prev;
    }
}

class MyCircularQueue {
    ListNode sentinel;
    int capacity;
    int size;

    public MyCircularQueue(int k) {
        sentinel = new ListNode();
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        capacity = k;
        size = 0;
    }
    
    public boolean enQueue(int value) {
        if (isFull()) return false;
        ListNode node = new ListNode(value);
        ListNode tail = sentinel.prev;

        tail.next = node;
        node.prev = tail;
        node.next = sentinel;
        sentinel.prev = node;
        size++;
        return true;
    }
    
    public boolean deQueue() {
        if (isEmpty()) return false;
        sentinel.next = sentinel.next.next;
        sentinel.next.prev = sentinel;
        size--;
        return true;
    }
    
    public int Front() {
        if (isEmpty()) return -1;
        return sentinel.next.val;
    }
    
    public int Rear() {
        if (isEmpty()) return -1;
        return sentinel.prev.val;
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public boolean isFull() {
        return size == capacity;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */