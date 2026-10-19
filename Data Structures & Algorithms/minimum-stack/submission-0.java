class MinStack {
    Stack<Integer> s;
    Stack<Integer> minStack;

    public MinStack() {
        s = new Stack<>();
        minStack = new Stack<>();
    }
    
    public void push(int val) {
        s.push(val);
        if (minStack.isEmpty() || val <= minStack.peek())
            minStack.push(val);
    }
    
    public void pop() {
        if (s.isEmpty())
            return;

        int poppedVal = s.pop();
        if (!minStack.isEmpty() && poppedVal == minStack.peek())
            minStack.pop();
    }
    
    public int top() {
        return s.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}
