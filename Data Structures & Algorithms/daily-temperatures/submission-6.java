class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int n = temperatures.length;
        int[] result = new int[n];
        for (int curr = 0; curr < n; curr++) {
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[curr]) {
                int prev = stack.pop();
                result[prev] = curr - prev;
            }
            stack.push(curr);
        }

        while (!stack.isEmpty()) {
            int prev = stack.pop();
            result[prev] = 0;
        }

        return result;
    }
}
