class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        int[][] cars = new int[n][2];
        for (int i = 0; i < n; i++) {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }

        Arrays.sort(cars, Comparator.comparingInt(a -> a[0]));
        Stack<Double> stack = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            int[] car = cars[i];
            int b = car[0];
            int m = car[1];
            double x = (double) (target - b) / m;
            // System.out.println("y[%d] = m[%d]x[%d] + b[%d]".formatted(target, m, x, b));
            if (stack.isEmpty() || stack.peek() < x) {
                stack.push(x);
            }
        }
        // System.out.println(stack.toString());
        return stack.size();
    }
}
