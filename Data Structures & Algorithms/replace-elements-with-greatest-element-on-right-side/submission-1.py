class Solution:
    def replaceElements(self, arr: List[int]) -> List[int]:
        n = len(arr)
        ans = [0] * n
        greatest = -1
        for i in range(n - 1, -1, -1):
            ans[i] = greatest
            greatest = max(greatest, arr[i])
        return ans