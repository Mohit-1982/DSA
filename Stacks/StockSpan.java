GFG

class Solution {
    public ArrayList<Integer> calculateSpan(int[] arr) {
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[n];
        st.push(0);
        ans[0] = 1;
        for(int i = 1;i<n;i++){
            while(st.size()>0 && arr[st.peek()]<=arr[i]) st.pop();
            if(st.size()==0) ans[i] = i+1;
            else ans[i] = i - st.peek();
            st.push(i);
        }
        ArrayList<Integer> a = new ArrayList<>();
        for(int i = 0;i<ans.length;i++){
            a.add(ans[i]);
        }
        return a;
    }
}
