class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> smallest = new PriorityQueue<>();
        for (int num : nums) {
            smallest.add(num);
            while (smallest.size() > k) {
                smallest.poll();
            }
        }
        return smallest.peek();
    }
}

