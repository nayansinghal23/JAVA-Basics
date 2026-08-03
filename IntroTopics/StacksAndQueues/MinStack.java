public class MinStack {
    // https://leetcode.com/problems/min-stack/

    private Stack<int[]> st;

    public MinStack() {
        st = new Stack<>();
    }
    
    public void push(int value) {
        st.push(new int[]{ value, Math.min(value, st.isEmpty() ? Integer.MAX_VALUE  : st.peek()[1]) });
    }
    
    public void pop() {
        st.pop();
    }
    
    public int top() {
        return st.peek()[0];
    }
    
    public int getMin() {
        return st.peek()[1];
    }
}
