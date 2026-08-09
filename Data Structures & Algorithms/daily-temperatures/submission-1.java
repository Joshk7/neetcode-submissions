class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] answer = new int[n];
        Arrays.fill(answer, 0);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            int temp = temperatures[i];
            while (!stack.isEmpty()) {
                int prevTemp = temperatures[stack.peek()];
                if (temp <= prevTemp) {
                    break;
                }
                int index = stack.pop();
                answer[index] = i - index;
            }
            stack.push(i);
        }

        return answer;
    }
}
