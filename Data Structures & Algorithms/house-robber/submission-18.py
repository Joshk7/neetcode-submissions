class Solution:
    def rob(self, nums: List[int]) -> int:
        n = len(nums)
        if n == 1:
            return nums[0]
        
        one = nums[0]
        two = max(nums[0], nums[1])
        for i in range(2, n):
            tmp = max(one + nums[i], two)
            one = two
            two = tmp
        return two
