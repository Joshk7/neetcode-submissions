class Solution:
    def canJump(self, nums: List[int]) -> bool:
        n = len(nums)
        cache = {}
        cache[n - 1] = True
        def dfs(i):
            if i in cache:
                return cache[i]
            
            cache[i] = False
            for j in range(i + 1, min(i + nums[i] + 1, n)):
                cache[i] |= dfs(j)
            
            return cache[i]
        answer = dfs(0)
        return answer