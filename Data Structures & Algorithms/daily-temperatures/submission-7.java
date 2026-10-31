class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int n = temperatures.length;
        int[] result = new int[n];
        for (int curr = 0; curr < n; curr++) {
            for (int next = curr; next < n; next++) {
                if (temperatures[next] > temperatures[curr]) {
                    result[curr] = next - curr;
                    break;
                }
            }
        }

        return result;
    }
}
