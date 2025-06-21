class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> future = new Stack<>();
        int[] result = new int[temperatures.length];
        for (int i = temperatures.length - 1; i >= 0; i--) {
            while (!future.empty()) {
                if (temperatures[i] < temperatures[future.peek()]) {
                    break;
                }
                future.pop();
            }

            if (future.empty()) {
                result[i] = 0;
            } else {
                result[i] = future.peek() - i;
            }
            future.push(i);
        }
        return result;
    }
}

