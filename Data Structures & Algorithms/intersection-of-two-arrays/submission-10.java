class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        List<Integer> res = new ArrayList<>();
        int i = 0, j = 0;

        while (i < nums1.length && j < nums2.length) {
            while (j < nums2.length && nums2[j] < nums1[i]) {
                j++;
            }
            if (j < nums2.length) {
                if (nums1[i] == nums2[j]) {
                    res.add(nums1[i]);
                }
                i++;
                while (i < nums1.length && nums1[i] == nums1[i - 1]) {
                    i++;
                }
            }
        }

        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}