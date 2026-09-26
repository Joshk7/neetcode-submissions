class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> one = new HashSet<>();
        for (int n : nums1) {
            one.add(n);
        }

        Set<Integer> two = new HashSet<>();
        for (int n : nums2) {
            two.add(n);
        }

        List<Integer> result = new ArrayList<>();
        for (int n : one) {
            if (two.contains(n)) {
                result.add(n);
            }
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}