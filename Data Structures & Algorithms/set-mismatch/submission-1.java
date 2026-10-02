class Solution {
    public int[] findErrorNums(int[] nums) {
        int[] res = new int[2];
        int n = nums.length;

        for (int i = 1; i <= n; i++) {
            int cnt = 0;
            for (int num : nums) {
                if (num == i) {
                    cnt++;
                }
            }

            if (cnt == 0) {
                res[1] = i;
            } else if (cnt == 2) {
                res[0] = i;
            }
        }

        return res;
    }
}