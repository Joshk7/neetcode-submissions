class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int consecutive = 0;
        int maxConsecutive = 0;
        for (int num : nums) {
            if (num == 0) {
                consecutive = 0;
            } else {
                consecutive++;
            }

            maxConsecutive = Math.max(maxConsecutive, consecutive);
        }

        return maxConsecutive;
    }
}