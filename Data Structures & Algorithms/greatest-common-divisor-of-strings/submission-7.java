class Solution {
    public String gcdOfStrings(String str1, String str2) {
        String ans = "";

        for (int i = 0; i < str1.length(); i++) {
            for (int j = i; j < str1.length(); j++) {
                String substring = str1.substring(i, j + 1);
                if (j - i + 1 > ans.length()) {
                    if (divides(substring, str2) && divides(substring, str1)) {
                        ans = substring;

                    }
                }
            }
        }

        return ans;
    }

    private boolean divides(String s1, String s2) {
        String s = s1;
        while (s.length() < s2.length()) {
            s = s + s1;
        }
        return s.equals(s2);
    }
}