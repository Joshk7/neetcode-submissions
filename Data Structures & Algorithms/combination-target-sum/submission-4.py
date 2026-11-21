class Solution:
    def combinationSum(self, nums: List[int], target: int) -> List[List[int]]:
        answer = []
        nums.sort()
        def backtrack(i, cur, total):
            if i == len(nums):
                return
            
            if total > target:
                return
            
            if total == target:
                answer.append(cur.copy())
                return
            
            cur.append(nums[i])
            backtrack(i, cur, total + nums[i])
            cur.pop()
            backtrack(i + 1, cur, total)
        
        backtrack(0, [], 0)
        return answer
