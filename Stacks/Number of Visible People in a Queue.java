Leetcode - 1944
Teachers Approach :

class Solution {
    public int[] canSeePersonsCount(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int n = arr.length;
        int count = 0;
        int[] ans = new int[n];
        ans[n-1] = 0;
        st.push(arr[n-1]);
        for(int i = n-2;i>=0;i--){
            count = 0;
            while(st.size()>0 && arr[i] >= st.peek()){
                count++;
                st.pop();
            }
            if(st.size()>0) count++;
            ans[i] = count;
            st.push(arr[i]);
        }
        return ans;
    }
}


Complete My approach :


class Solution {
    public int[] canSeePersonsCount(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int n = arr.length;
        int count = 0;
        int[] ans = new int[n];
        ans[n-1] = 0;
        st.push(arr[n-1]);
        for(int i = n-2;i>=0;i--){
            count = 0;
            if(st.size()>0 && arr[i] < st.peek()){
                count++;
                st.push(arr[i]);
            }
            if(st.size()>0 && arr[i] > st.peek()){
                while(st.size()>0 && arr[i] > st.peek()){
                    st.pop();
                    count++;
                }
                if(st.size()>0 && arr[i] < st.peek()) count++;
                st.push(arr[i]);
            }
            ans[i] = count;
        }
        return ans;
    }
}
