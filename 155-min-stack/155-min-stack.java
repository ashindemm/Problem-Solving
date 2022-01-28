class MinStack {
    
    List<Integer> stk = null;
    List<Integer> min = null;

    public MinStack() {
        stk = new ArrayList<Integer> ();
        min = new ArrayList<Integer> ();
    }
    
    public void push(int val) {
        stk.add(val);
        if (min.isEmpty()) {
            min.add(val);
        } else {
            min.add(Math.min(min.get(min.size() - 1), val));
        }
    }
    
    public void pop() {
        if (!stk.isEmpty()) {
            stk.remove(stk.size() - 1);
            min.remove(min.size() - 1);
        }
    }
    
    public int top() {
        return stk.isEmpty() ? 0 : stk.get(stk.size() - 1);
    }
    
    public int getMin() {
        return min.isEmpty() ? 0 : min.get(min.size() - 1);
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */