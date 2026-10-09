class StockSpanner {
    List<Integer> stocks;

    public StockSpanner() {
        stocks = new ArrayList<>();
    }
    
    public int next(int price) {
        stocks.add(price);
        int n = stocks.size();

        for (int i = n - 2; i >= 0; i--) {
            if (stocks.get(i) > price) {
                return n - i - 1;
            }
        }

        return n;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */