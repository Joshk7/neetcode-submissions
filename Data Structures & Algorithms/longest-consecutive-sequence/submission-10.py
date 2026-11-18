class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        n = len(nums)
        longest = 0
        sorted_nums = sorted(nums)
        i = 0
        while i < n:
            j = i
            while j + 1 < n and sorted_nums[j + 1] - sorted_nums[j] <= 1:
                j += 1
            longest = max(longest, sorted_nums[j] - sorted_nums[i] + 1)
            i = j + 1
        return longest
        