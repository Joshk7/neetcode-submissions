class MedianFinder {
    private List<Integer> list;

    public MedianFinder() {
        list = new ArrayList<>();
    }
    
    public void addNum(int num) {
        list.add(num);
    }
    
    public double findMedian() {
        if (list.isEmpty()) {
            return 0.0;
        }
        Collections.sort(list);
        int n = list.size();
        if (n % 2 == 0) {
            int left = list.get((n - 1) / 2);
            int right = list.get((n + 1) / 2);
            return (double) (right + left) / 2;
        } else {
            return list.get(n / 2);
        }
    }
}
