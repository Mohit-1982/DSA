Leetcode - 225

// Add efficient aprroach
class MyStack {
    Queue<Integer> q = new LinkedList<>();
    public MyStack() {
        
    }
    
    public void push(int x) {
        q.add(x);
    }
    
    public int pop() {
        int n = q.size();
        for(int i = 0;i<n-1;i++) q.add(q.remove());
        int top = q.remove();
        return top;
    }
    
    public int top() {
        int n = q.size();
        for(int i = 0;i<n-1;i++) q.add(q.remove());
        int top = q.peek();
        q.add(q.remove());
        return top;
    }
    
    public boolean empty() {
        return (q.size()==0);
    }
}


// POP and PEEK efficient aprroach
class MyStack {
    Queue<Integer> q = new LinkedList<>();
    public MyStack() {
        
    }
    
    public void push(int x) { //q k front pe add karna
        q.add(x);
        for(int i = 0;i<q.size()-1;i++) q.add(q.remove());
    }
    
    public int pop() {
        return q.remove();
    }
    
    public int top() {
        return q.peek(); 
    }
    
    public boolean empty() {
        return (q.size()==0);
    }
}
