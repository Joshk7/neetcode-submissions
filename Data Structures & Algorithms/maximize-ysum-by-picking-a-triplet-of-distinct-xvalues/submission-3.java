class Solution {
    public int maxSumDistinctTriplet(int[] x, int[] y) {
        Map<Integer, Integer> m = new HashMap<>();
        for (int i = 0; i < x.length; i++) {
            int key = x[i], val = y[i];
            m.put(key, Math.max(m.getOrDefault(key, 0), val));
        }

        if (m.size() < 3) return -1;
        List<Integer> vals = new ArrayList<>(m.values());
        Collections.sort(vals);
        int n = vals.size();
        return vals.get(n - 1) + vals.get(n - 2) + vals.get(n - 3);
    }
}