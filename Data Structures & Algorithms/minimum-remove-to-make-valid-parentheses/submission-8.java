class Solution {
    public String minRemoveToMakeValid(String s) {
        int closeCnt = 0, openCnt = 0, n = s.length();
        for (char c : s.toCharArray()) {
            if (c == ')') closeCnt++;
        }
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '(') {
                if (openCnt == closeCnt) continue;
                openCnt++;
                sb.append(c);
            } else if (c == ')') {
                closeCnt--;
                if (openCnt == 0) continue;
                openCnt--;
                sb.append(c);
            } else {
                sb.append(c);
            }
        }

        return sb.toString();
    }
}