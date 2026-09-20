class Solution {
    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int n = s.length();
        for (int i = n - 1; i >= 0; i--) {
            char key = s.charAt(i);
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        for (int i = 0; i < n; i++) {
            char key = s.charAt(i);
            if (map.get(key) == 1) {
                return i;
            }
        }

        return -1;
    }
}