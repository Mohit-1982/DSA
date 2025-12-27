Leetcode - 682

class Solution {
    public int calPoints(String[] arr) {
        Stack<Integer> st = new Stack<>();
        for(int i = 0;i<arr.length;i++){
            String ch = arr[i];
            if(ch.equals("C")) st.pop();
            else if(ch.equals("D")) st.push(2*st.peek());
            else if(ch.equals("+")) {
                int top = st.pop();
                int sum = top + st.peek();
                st.push(top);//first push top
                st.push(sum);//then push sum
            }
            else{
                int n = Integer.parseInt(ch);
                st.push(n);
            }
        }
        int ans = 0;
        while(st.size() > 0){
            ans += st.pop();
        }
        return ans;
    }
}
