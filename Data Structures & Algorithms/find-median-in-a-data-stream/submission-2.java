class MedianFinder {
    private PriorityQueue<Integer> maxHeap;
    private PriorityQueue<Integer> minHeap;

    public MedianFinder() {
        maxHeap = new PriorityQueue<Integer>((a, b) -> Integer.compare(b, a));
        minHeap = new PriorityQueue<Integer>();
    }
    
    public void addNum(int num) {
        if (!minHeap.isEmpty() && num > minHeap.peek()) {
            minHeap.offer(num);
        } else {
            maxHeap.offer(num);
        }

        int diff = Math.abs(minHeap.size() - maxHeap.size());
        if (diff > 1) {
            if (minHeap.size() > maxHeap.size()) {
                maxHeap.offer(minHeap.poll());
            } else {
                minHeap.offer(maxHeap.poll());
            }
        }
    }
    
    public double findMedian() {
        int total = maxHeap.size() + minHeap.size();
        if (total % 2 == 0) {
            int left = maxHeap.peek();
            int right = minHeap.peek();
            return (double) (left + right) / 2;
        } else {
            if (minHeap.size() > maxHeap.size()) {
                return minHeap.peek();
            } else {
                return maxHeap.peek();
            }
        }
    }
}
