class Solution {
    class Bar {
        int index;
        int height;

        Bar(int index, int height) {
            this.index = index;
            this.height = height;
        }
    }

    public int largestRectangleArea(int[] heights) {
        Stack<Bar> stack = new Stack<>();
        int largest = 0;
        for (int i = 0; i < heights.length; i++) {
            int start = i;
            while (!stack.empty()) {
                Bar previous = stack.peek();
                if (previous.height < heights[i]) {
                    break;
                }

                int area = (i - previous.index) * previous.height;
                largest = Math.max(area, largest);
                stack.pop();
                start = previous.index;
            }

            stack.push(new Bar(start, heights[i]));
        }

        while (!stack.empty()) {
            Bar current = stack.peek();
            int area = (heights.length - current.index) * current.height;
            largest = Math.max(area, largest);
            stack.pop();
        }
        return largest;
    }
}

