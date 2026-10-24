class Solution {
    public String addSpaces(String s, int[] spaces) {
        int n = s.length();
        int m = spaces.length;
        StringBuilder sb = new StringBuilder();
        int j = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (j < m && spaces[j] == i) {
                sb.append(' ');
                j++;
            }

            sb.append(c);
        }

        return sb.toString();
    }
}
