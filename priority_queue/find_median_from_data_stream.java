class MedianFinder {

    private PriorityQueue<Integer> left;
    private PriorityQueue<Integer> right;

    public MedianFinder() {
        left = new PriorityQueue<>((a, b) -> b - a);
        right = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if (left.isEmpty()) {
            left.add(num);
            return;
        }

        if (num < left.peek()) {
            left.add(num);
        } else {
            right.add(num);
        }
        balance();
    }
    
    private void balance() {
        while (left.size() < right.size()) {
            left.add(right.poll());
        }
        while (left.size() > right.size() + 1) {
            right.add(left.poll());
        }
    }
    
    public double findMedian() {
        int size = left.size() + right.size();
        if (size % 2 == 1) {
            return left.peek();
        }

        return (double) (left.peek() + right.peek()) / 2;
    }
}

