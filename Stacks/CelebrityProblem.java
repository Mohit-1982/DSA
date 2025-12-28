GFG

class Solution {
    public int celebrity(int arr[][]) {
        int n = arr.length;
        int m = arr[0].length;
        Stack<Integer> st = new Stack<>();
        for(int i = 0;i<n;i++){
            st.push(i);
        }
        
        while(st.size()>1){
            int a = st.pop();
            int b = st.pop();
            if(arr[a][b] == 1) st.push(b);
            else st.push(a);
        }
        
            int c = st.pop();
            for(int i = 0;i<n;i++){
                if(arr[c][i] == 1 && c != i) return -1;
            }
            for(int i = 0;i<n;i++){
                if(arr[i][c] == 0 && c != i) return -1;
            }
        return c;
    }
}
