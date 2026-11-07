class Solution {
    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        List<int[]> arr = new ArrayList<>();
        for (int i = 0; i < username.length; i++) {
            arr.add(new int[]{timestamp[i], i});
        }
        arr.sort((a, b) -> Integer.compare(a[0], b[0]));

        Map<String, List<String>> map = new HashMap<>();
        for (int[] p : arr) {
            int idx = p[1];
            map.computeIfAbsent(username[idx], k -> new ArrayList<>()).add(website[idx]);
        }

        Map<String, Integer> count = new HashMap<>();
        for (String user : map.keySet()) {
            List<String> cur = map.get(user);
            Set<String> patterns = new HashSet<>();
            for (int i = 0; i < cur.size(); i++) {
                for (int j = i + 1; j < cur.size(); j++) {
                    for (int k = j + 1; k < cur.size(); k ++) {
                        patterns.add(cur.get(i) + "#" + cur.get(j) + "#" + cur.get(k));
                    }
                }
            }
            for (String p : patterns) {
                count.put(p, count.getOrDefault(p, 0) + 1);
            }
        }

        String res = "";
        int maxCount = 0;
        for (String p : count.keySet()) {
            int c = count.get(p);
            if (c > maxCount || (c == maxCount && p.compareTo(res) < 0)) {
                maxCount = c;
                res = p;
            }
        }

        return Arrays.asList(res.split("#"));
    }
}