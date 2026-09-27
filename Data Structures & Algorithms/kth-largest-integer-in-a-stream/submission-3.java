class KthLargest {
    private List<Integer> elements;
    private int k;

    public KthLargest(int k, int[] nums) {
        this.elements = new ArrayList<>();
        this.k = k;

        for (int num : nums) {
            this.elements.add(num);
        }
    }
    
    public int add(int val) {
        this.elements.add(val);
        Collections.sort(this.elements, Collections.reverseOrder());
        return this.elements.get(k - 1);
    }
}
