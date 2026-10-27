class Solution {
    public int largestCombination(int[] candidates) {
        int best = 0;
        for (int bit = 0; bit < 24; bit++) {
            int count = 0;
            for (int x : candidates) if ((x & (1 << bit)) != 0) count++;
            best = Math.max(best, count);
        }
        return best;
    }
}
