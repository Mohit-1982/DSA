GFG
  class Solution {
    public static int[] help_classmate(int arr[], int n) {
        //Next smaller using stack
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[n];
        ans[ans.length - 1] = -1;
        st.push(arr[arr.length - 1]);
        int i = arr.length - 2;
        while(i >= 0) {
            while(st.size() > 0 && st.peek() >= arr[i]) {
                st.pop();
            }
            if(st.size() == 0) {
                ans[i] = -1;
            }else {
                ans[i] = st.peek();
            }
            st.push(arr[i]);
            i--;
        }
        return ans;
    }
}
