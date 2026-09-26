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

        two.retainAll(one);
        return two.stream().mapToInt(Integer::intValue).toArray();
    }
}