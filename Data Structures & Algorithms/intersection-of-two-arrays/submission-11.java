class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> res = new HashSet<>();
        for (int n1 : nums1) {
            for (int n2 : nums2) {
                if (n1 == n2) {
                    res.add(n1);
                }
            }
        }

        int[] result = new int[res.size()];
        int idx = 0;
        for (int num : res) {
            result[idx++] = num;
        }
        return result;
    }
}