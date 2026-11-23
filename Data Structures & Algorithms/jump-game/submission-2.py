class Solution:
    def canJump(self, nums: List[int]) -> bool:
        n = len(nums)
        furthest = n - 1
        for i in range(n - 1, -1, -1):
            if furthest <= nums[i] + i:
                furthest = i
        return furthest == 0