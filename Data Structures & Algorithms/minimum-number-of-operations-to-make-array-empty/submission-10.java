class Solution {
    public int minOperations(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        int res = 0;
        for (int cnt : count.values()) {
            if (cnt == 1) {
                return -1;
            }
            res += (cnt + 2) / 3;
        }

        return res;
    }
}