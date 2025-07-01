class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> indices = new PriorityQueue<>((i, j) -> {
            return nums[j] - nums[i];
        });
        for (int i = 0; i < k - 1; i++) {
            indices.add(i);
        }

        int[] maximums = new int[nums.length - k + 1];      
        for (int i = 0; i < maximums.length; i++) {
            int index = i + k - 1;
            indices.add(index);
            while (indices.peek() < i) {
                indices.poll();
            }
            maximums[i] = nums[indices.peek()];
        }
        return maximums;
    }
}

