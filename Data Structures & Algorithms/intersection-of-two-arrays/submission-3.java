class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Map<Integer, Integer> seen = new HashMap<>();
        for (int num : nums1) {
            seen.put(num, 1);
        }

        List<Integer> res = new ArrayList<>();
        for (int num : nums2) {
            if (seen.getOrDefault(num, 0) == 1) {
                seen.put(num, 0);
                res.add(num);
            }
        }

        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}