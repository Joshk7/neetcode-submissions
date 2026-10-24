class Solution {
    public String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!stack.isEmpty() && c == ')' && s.charAt(stack.peek()) == '(') {
                stack.pop();
            } else if (c == '(' || c == ')') {
                stack.push(i);
            }
            sb.append(c);
        }

        while (!stack.isEmpty()) {
            int i = stack.pop();
            sb.deleteCharAt(i);
        }

        return sb.toString();
    }
}