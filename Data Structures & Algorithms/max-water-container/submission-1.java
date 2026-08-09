class Solution {
    public int maxArea(int[] heights) {
        int answer = 0;
        for (int i = 0; i < heights.length; i++) {
            for (int j = i + 1; j < heights.length; j++) {
                int height = Math.min(heights[i], heights[j]);
                int width = j - i;
                int area = height * width;
                answer = Math.max(answer, area);
            }
        }
        return answer;
    }
}
