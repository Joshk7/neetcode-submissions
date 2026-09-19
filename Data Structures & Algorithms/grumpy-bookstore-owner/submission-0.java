class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int n = customers.length;
        int presatisfied = 0;
        for (int i = 0; i < n; i++) {
            if (grumpy[i] == 0) {
                presatisfied += customers[i];
            }
        }

        int postsatisfied = 0;
        for (int i = 0; i < minutes; i++) {
            if (grumpy[i] == 1) {
                postsatisfied += customers[i];
            }
        }

        int l = 0;
        int satisfied = presatisfied + postsatisfied;
        for (int r = minutes; r < n; r++) {
            if (grumpy[r] == 1) {
                postsatisfied += customers[r];
            }

            if (grumpy[l] == 1) {
                postsatisfied -= customers[l];
            }

            l++;
            satisfied = Math.max(satisfied, presatisfied + postsatisfied);
        }

        return satisfied;
    }
}