class Solution {
    public boolean checkValidString(String s) {
        Stack<Integer> paren = new Stack<>();
        Stack<Integer> wild = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') paren.push(i);
            if (c == ')') {
                if (!paren.isEmpty()) {
                    paren.pop();
                } else if (!wild.isEmpty()) {
                    wild.pop();
                } else {
                    return false;
                }
            }
            if (c == '*') wild.push(i);
        }

        while (!paren.isEmpty()) {
            if (wild.isEmpty()) return false;
            if (wild.peek() < paren.peek()) return false;
            paren.pop();
            wild.pop();
        }

        return true;
    }
}
