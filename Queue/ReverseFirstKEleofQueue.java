GFG

class Solution {
    public Queue<Integer> reverseFirstK(Queue<Integer> q, int k) {
        Stack<Integer> st = new Stack<>();
        if(k > q.size()) return q;
        for(int i = 0;i<k;i++){
            st.push(q.remove());
        }
        while(st.size()>0) q.add(st.pop());
        for(int i = 0;i<q.size()-k;i++){
            q.add(q.remove());
        }
        return q;
    }
}
