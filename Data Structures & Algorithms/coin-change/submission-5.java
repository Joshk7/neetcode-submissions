class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }

        boolean[] seen = new boolean[amount + 1];
        Queue<Integer> q = new LinkedList<>();
        q.offer(amount);
        seen[amount] = true;

        int count = 0;
        while (!q.isEmpty()) {
            count++;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int n = q.poll();
                for (int c : coins) {
                    if (n - c < 0) continue;
                    if (seen[n - c]) continue;
                    if (n - c == 0) return count;
                    seen[n - c] = true;
                    q.offer(n - c);
                }
            }
        }

        return -1;
    }
}
