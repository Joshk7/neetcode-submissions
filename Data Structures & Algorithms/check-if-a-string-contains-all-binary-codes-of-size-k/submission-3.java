class Solution {
    public boolean hasAllCodes(String s, int k) {
        int n = s.length();
        Set<String> codes = new HashSet<>();
        for (int l = 0; l < n - k + 1; l++) {
            int r = l + k;
            String substring = s.substring(l, r);
            codes.add(substring);
        }
        return codes.size() == (int) Math.pow(2, k);
    }
}
