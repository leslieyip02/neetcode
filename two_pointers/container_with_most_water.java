class Solution {
    public int maxArea(int[] heights) {
        int left = 0;
        int right = heights.length - 1;
        int area = 0;
        while (left < right) {
            int current = Math.min(heights[left], heights[right]) * (right - left);
            area = Math.max(current, area);
            if (heights[left] < heights[right]) {
                left++;
            } else {
                right--;
            }
        }
        return area;
    }
}

