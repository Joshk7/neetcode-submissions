class Solution:
    def maxArea(self, heights: List[int]) -> int:
        l = 0
        r = len(heights) - 1
        area = 0
        while l < r:
            height = min(heights[l], heights[r])
            width = r - l
            area = max(area, height * width)
            if heights[l] < heights[r]:
                l += 1
            else:
                r -= 1
        return area