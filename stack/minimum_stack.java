class MinStack {

    private Stack<Integer> stack;
    private Stack<Integer> minimums;

    public MinStack() {
        this.stack = new Stack<>();
        this.minimums = new Stack<>();
    }
    
    public void push(int val) {
        stack.push(val);
        if (minimums.empty()) {
            minimums.push(val);
        } else {
            minimums.push(Math.min(minimums.peek(), val));
        }
    }
    
    public void pop() {
        stack.pop();
        minimums.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minimums.peek();
    }
}

