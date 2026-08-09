class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int p1 = 0;
        int p2 = 0;
        List<Integer> res = new ArrayList<>();
        while (p1 < nums1.length && p2 < nums2.length) {
            int x1 = nums1[p1];
            int x2 = nums2[p2];
            if (x1 < x2) {
                p1++;
            } else if (x2 < x1) {
                p2++;
            } else {
                res.add(x1);
                while (p1 < nums1.length && nums1[p1] == x1) {
                    p1++;
                }

                while (p2 < nums2.length && nums2[p2] == x2) {
                    p2++;
                }
            }
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}