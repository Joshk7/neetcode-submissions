class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> seen = new HashSet<>();
        for (int n : nums1) seen.add(n);

        Set<Integer> result = new HashSet<>();
        for (int n : nums2) {
            if (seen.contains(n)) result.add(n);
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}