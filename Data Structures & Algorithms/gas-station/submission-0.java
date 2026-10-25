class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sumGas = 0, sumCost = 0, n = gas.length;
        for (int i = 0; i < n; i++) {
            sumGas += gas[i];
            sumCost += cost[i];
        }

        if (sumGas < sumCost) return -1;

        int total = 0;
        int index = 0;
        for (int i = 0; i < n; i++) {
            total += (gas[i] - cost[i]);
            if (total < 0) {
                total = 0;
                index = i + 1;
            }
        }
        return index;
    }
}
