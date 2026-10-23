class Solution {
    public double averageWaitingTime(int[][] customers) {
        long t = 0, total = 0;

        for (int[] c : customers) {
            int arrival = c[0], order = c[1];
            if (t > arrival) {
                total += t - arrival;
            } else {
                t = arrival;
            }
            total += order;
            t += order;
        }

        return (double) total / customers.length;
    }
}