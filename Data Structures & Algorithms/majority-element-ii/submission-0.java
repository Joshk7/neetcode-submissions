class Solution {
    public List<Integer> majorityElement(int[] nums) {
        Map<Integer, Integer> counts = new HashMap<>();
        for (int num : nums) {
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }

        int n = nums.length;
        List<Integer> ans = new ArrayList<>();
        for (Map.Entry<Integer, Integer> e : counts.entrySet()) {
            int key = e.getKey();
            int val = e.getValue();
            if (val > n / 3) {
                ans.add(key);
            }
        }

        return ans;
    }
}