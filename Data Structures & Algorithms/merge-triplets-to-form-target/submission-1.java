class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        int[] current = new int[3];
        for (int[] triplet : triplets) {
            boolean contribute = true;
            for (int i = 0; i < 3; i++) {
                if (triplet[i] > target[i]) {
                    contribute = false;
                    break;
                }
            }

            if (!contribute) continue;
            int matching = 0;
            for (int i = 0; i < 3; i++) {
                current[i] = Math.max(current[i], triplet[i]);
                matching += current[i] == target[i] ? 1 : 0;
                if (matching == 3) return true;
            }
        }

        return false;
    }
}
