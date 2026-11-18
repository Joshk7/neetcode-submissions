class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        n = len(nums)
        ans = [0] * n
        prefix = [1] * (n + 1)
        for i in range(n):
            prefix[i + 1] = prefix[i] * nums[i]
        suffix = 1
        for i in range(n - 1, -1, -1):
            ans[i] = prefix[i] * suffix
            suffix *= nums[i]
        return ans