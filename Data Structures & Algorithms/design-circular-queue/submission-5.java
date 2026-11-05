class ListNode {
    int val;
    ListNode next;

    public ListNode() {
        val = -1;
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class MyCircularQueue {
    ListNode tail;
    int size;
    int capacity;

    public MyCircularQueue(int k) {
        tail = new ListNode();
        tail.next = tail;
        size = 0;
        capacity = k;
    }
    
    public boolean enQueue(int value) {
        if (isFull()) return false;

        ListNode node = new ListNode(value);
        if (isEmpty()) {
            tail = node;
            tail.next = tail;
        } else {
            node.next = tail.next;
            tail.next = node;
            tail = node;
        }

        size++;
        return true;
    }
    
    public boolean deQueue() {
        if (isEmpty()) return false;
        
        if (size == 1) {
            tail.next = tail;
        } else {
            tail.next = tail.next.next;
        }

        size--;
        return true;
    }
    
    public int Front() {
        if (isEmpty()) return -1;
        return tail.next.val;
    }
    
    public int Rear() {
        if (isEmpty()) return -1;
        return tail.val;
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