class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        n = len(nums)
        nums = sorted(nums)
        # nums[i] + nums[j] + nums[k] == 0
        # -> nums[j] + nums[k] == -nums[i]
        answer = []
        for i in range(n - 2):
            if i != 0 and nums[i - 1] == nums[i]:
                continue
            j = i + 1
            k = n - 1
            while j < k:
                total = nums[i] + nums[j] + nums[k]
                if total > 0:
                    k -= 1
                elif total < 0:
                    j += 1
                else:
                    answer.append([nums[i], nums[j], nums[k]])
                    while j + 1 < k and nums[j] == nums[j + 1]:
                        j += 1
                    j += 1
        return answer