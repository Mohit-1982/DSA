

class Solution {
    public ArrayList<Integer> nextLargerElement(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int n = arr.length;
        
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = 0;i<n;i++){
            ans.add(0);
        }
        st.push(arr[n-1]);
        ans.set(n-1,-1);
        
        for(int i = n-2;i>=0;i--){
            while(st.size()>0 && st.peek()<=arr[i]){
                st.pop();
            }
            
            if(st.size()==0) ans.set(i,-1);
            else ans.set(i,st.peek());
            st.push(arr[i]);
        }
        return ans;
    }
}
