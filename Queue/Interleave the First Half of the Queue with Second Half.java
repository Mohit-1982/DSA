GFG

Approach 1 :  O(n) time and O(n/2) space
class Solution {
    public void rearrangeQueue(Queue<Integer> q) {
        int n = q.size();
        Queue<Integer> s = new LinkedList<>();
        for(int i = 0;i<n/2;i++){
            s.add(q.remove());
        }
        while(s.size()>0){
            q.add(s.remove());
            q.add(q.remove());
        }
    }
}


Approach 2 : Using stack 

class Solution {
    public void rearrangeQueue(Queue<Integer> q) {
        Stack<Integer> st = new Stack<>();
        int n = q.size();
        for(int i = 0;i<n/2;i++){
            st.push(q.remove());
        }
        while(st.size()>0) q.add(st.pop());
        for(int i = 0;i<n/2;i++){
            st.push(q.remove());
        }
        while(st.size()>0){
            q.add(st.pop());
            q.add(q.remove());
        }
        for(int i = 0;i<n;i++) st.push(q.remove());
        while(st.size()>0) q.add(st.pop());
    }
}

