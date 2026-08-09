class TimeMap {
    Map<String, List<Pair<Integer, String>>> m;

    public TimeMap() {
        m = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if (!m.containsKey(key)) {
            m.put(key, new ArrayList<>());
        }
        m.get(key).add(new Pair(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        String res = "";
        List<Pair<Integer, String>> values = m.getOrDefault(key, new ArrayList<>());

        int l = 0;
        int r = values.size() - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (values.get(m).getKey() <= timestamp) {
                res = values.get(m).getValue();
                l = m + 1;
            } else {
                r = m - 1;
            }
        }

        return res;
    }
}
