class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> one = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
        Set<Integer> two = Arrays.stream(nums2).boxed().collect(Collectors.toSet());
        Set<Integer> intersection = new HashSet<>(one);
        intersection.retainAll(two);
        int[] result = intersection.stream().mapToInt(Integer::intValue).toArray();
        return result;
    }
}