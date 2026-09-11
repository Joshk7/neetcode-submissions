class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int ans = 0;
        for (int num : set) {
            if (set.contains(num - 1)) {
                continue;
            }

            int count = 1;
            while (set.contains(num + 1)) {
                num++;
                count++;
            }
            ans = Math.max(ans, count);
        }

        return ans;
    }
}
