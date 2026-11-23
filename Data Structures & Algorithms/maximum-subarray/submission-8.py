class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        ans = nums[0]
        cur = nums[0]
        for i in range(1, len(nums)):
            num = nums[i]
            cur = max(num, cur + num)
            ans = max(ans, cur)
        return ans
            