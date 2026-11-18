class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        longest = 0
        num_set = set(nums)
        for num in num_set:
            if not num - 1 in num_set:
                start = num
                end = num
                while end + 1 in num_set:
                    end += 1
                longest = max(longest, end - start + 1)
        return longest