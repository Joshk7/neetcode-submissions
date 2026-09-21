class Solution {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> count = new HashMap<>();
        for (char c : s1.toCharArray()) {
            count.put(c, count.getOrDefault(c, 0) - 1);
        }
        
        int n = s1.length();
        int m = s2.length();
        int l = 0;
        for (int r = 0; r < m; r++) {
            char kr = s2.charAt(r);
            count.put(kr, count.getOrDefault(kr, 0) + 1);
            if (count.get(kr) == 0) {
                count.remove(kr);
            }

            if (r - l + 1 > n) {
                char kl = s2.charAt(l);
                count.put(kl, count.getOrDefault(kl, 0) - 1);
                if (count.get(kl) == 0) {
                    count.remove(kl);
                }
                l++;
            }

            if (count.size() == 0) {
                return true;
            }
        }

        return false;
    }
}
