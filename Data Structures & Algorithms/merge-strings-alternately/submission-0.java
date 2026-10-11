class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        int p1 = 0;
        int p2 = 0;
        int l1 = word1.length();
        int l2 = word2.length();
        while (p1 < l1 && p2 < l2) {
            boolean even = sb.length() % 2 == 0;
            if (even) {
                sb.append(word1.charAt(p1));
                p1++;
            } else {
                sb.append(word2.charAt(p2));
                p2++;
            }
        }

        if (p1 < l1) {
            sb.append(word1.substring(p1, l1));
        }

        if (p2 < l2) {
            sb.append(word2.substring(p2, l2));
        }

        return sb.toString();
    }
}