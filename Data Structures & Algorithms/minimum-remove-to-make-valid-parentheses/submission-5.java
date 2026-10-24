class Solution {
    public String minRemoveToMakeValid(String s) {
        int n = s.length();
        char[] arr = s.toCharArray();
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '(') {
                cnt++;
            } else if (c == ')' && cnt > 0) {
                cnt--;
            } else if (c == ')') {
                arr[i] = '\0';
            }
        }

        StringBuilder res = new StringBuilder();
        for (int i = n - 1; i >= 0; i--) {
            char c = arr[i];
            if (c == '(' && cnt > 0) {
                cnt--;
            } else if (c != '\0') {
                res.append(c);
            }
        }

        return res.reverse().toString();
    }
}