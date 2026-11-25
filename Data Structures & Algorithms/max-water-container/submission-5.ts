class Solution {
    /**
     * @param {number[]} heights
     * @return {number}
     */
    maxArea(heights: number[]): number {
        let largest = 0,
            l = 0,
            n = heights.length,
            r = n - 1;
        
        while (l <= r) {
            const height = Math.min(heights[l], heights[r]);
            const width = r - l;
            largest = Math.max(largest, height * width);
            if (heights[l] < heights[r]) {
                l++;
            } else {
                r--;
            }
        }

        return largest;
    }
}
