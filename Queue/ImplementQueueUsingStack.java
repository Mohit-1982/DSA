Leetcode - 232

// *push efficient approach
class MyQueue {
    Stack<Integer> st = new Stack<>();
    Stack<Integer> help = new Stack<>(); 
    public MyQueue() {
        
    }
    
    public void push(int x) {
        st.push(x);
    }
    
    public int pop() {
        while(st.size()>1) help.push(st.pop());
        int top = st.pop();
        while(help.size()>0) st.push(help.pop());
        return top;
    }
    
    public int peek() {
        while(st.size()>1) help.push(st.pop());
        int top = st.peek();
        while(help.size()>0) st.push(help.pop());
        return top;
    }
    
    public boolean empty() {
        if(st.size()==0) return true;
        else return false;
    }
}


// * Pop and peek efficient approach
class MyQueue {
    Stack<Integer> st = new Stack<>();
    Stack<Integer> help = new Stack<>(); 
    public MyQueue() {
        
    }
    
    public void push(int x) { // O(n)
        // in this approach we have to push at bottom 
        while(st.size()>0) help.push(st.pop());
        st.push(x);
        while(help.size()>0) st.push(help.pop());
    }
    
    public int pop() { // O(1)
        return st.pop();
    }
    
    public int peek() { // O(1)
        return st.peek();
    }
    
    public boolean empty() {
        return (st.size()==0);
    }
