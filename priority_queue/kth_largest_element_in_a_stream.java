class KthLargest {

    int k;
    PriorityQueue<Integer> values;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.values = new PriorityQueue<>();
        for (int num : nums) {
            this.values.add(num);
        }
        while (this.values.size() > k) {
            this.values.poll();
        }
    }
    
    public int add(int val) {
        this.values.add(val);
        while (this.values.size() > k) {
            this.values.poll();
        }
        return this.values.peek();
    }
}

