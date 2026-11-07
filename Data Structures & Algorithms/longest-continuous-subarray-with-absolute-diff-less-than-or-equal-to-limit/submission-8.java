class Solution {
    public int longestSubarray(int[] nums, int limit) {
        Deque<Integer> min = new LinkedList<>();
        Deque<Integer> max = new LinkedList<>();

        int l = 0, n = nums.length, longest = 1;
        for (int r = 0; r < n; r++) {
            while (!min.isEmpty() && min.peekLast() > nums[r]) {
                min.pollLast();
            }

            while (!max.isEmpty() && max.peekLast() < nums[r]) {
                max.pollLast();
            }

            min.offerLast(nums[r]);
            max.offerLast(nums[r]);

            while (max.peekFirst() - min.peekFirst() > limit) {
                if (nums[l] == min.peekFirst()) {
                    min.pollFirst();
                }

                if (nums[l] == max.peekFirst()) {
                    max.pollFirst();
                }

                l++;
            }

            System.out.println(min.toString());
            System.out.println(max.toString());
            longest = Math.max(longest, r - l + 1);
        }

        return longest;
    }
}