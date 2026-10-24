class Solution {
    public String minRemoveToMakeValid(String s) {
        int n = s.length();
        char[] arr = s.toCharArray();
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(i);
            } else if (c == ')' && !stack.isEmpty()) {
                stack.pop();
            } else if (c == ')' && stack.isEmpty()) {
                arr[i] = '\0';
            }
        }

        while (!stack.isEmpty()) {
            arr[stack.pop()] = '\0';
        }

        StringBuilder res = new StringBuilder();
        for (int i = n - 1; i >= 0; i--) {
            char c = arr[i];
            if (c != '\0') {
                res.append(c);
            }
        }

        return res.reverse().toString();
    }
}