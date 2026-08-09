class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> closeToOpen = new HashMap<>();
        closeToOpen.put(')', '(');
        closeToOpen.put(']', '[');
        closeToOpen.put('}', '{');

        for (char c : s.toCharArray()) {
            if (closeToOpen.containsKey(c)) {
                if (stack.isEmpty()) {
                    return false;
                }

                if (stack.pop() != closeToOpen.get(c)) {
                    return false;
                }
            } else {
               stack.push(c); 
            }
        }
        return stack.size() == 0;
    }
}
