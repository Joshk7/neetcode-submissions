class Solution {
    public String removeKdigits(String num, int k) {
        StringBuilder stack = new StringBuilder();
        
        // Step 1: Build the monotonic increasing stack
        for (char c : num.toCharArray()) {
            while (k > 0 && stack.length() > 0 && stack.charAt(stack.length() - 1) > c) {
                stack.setLength(stack.length() - 1);
                k--;
            }
            stack.append(c);
        }
        
        // Step 2: If k is still > 0, remove from the end
        stack.setLength(stack.length() - k);
        
        // Step 3: Remove leading zeros
        int first = 0;
        while (first < stack.length() && stack.charAt(first) == '0') {
            first++;
        }
        
        // Step 4: Return result, handling empty strings as "0"
        return first == stack.length() ? "0" : stack.substring(first);
    }
}