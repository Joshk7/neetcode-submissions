class Solution:
    def hasDuplicate(self, nums: List[int]) -> bool:
        dups = set()
        for num in nums:
            if num in dups:
                return True
            dups.add(num)
        return False