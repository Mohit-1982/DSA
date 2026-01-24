Leetcode - 2326
  class Solution {
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] arr = new int[m][n];
        arr = createMatrix(arr,head,m,n);
        return arr;
    }
    public int[][] createMatrix(int[][] arr,ListNode head,int m,int n) {
        int fr = 0;
        int lr = m - 1;
        int fc = 0;
        int lc = n - 1;
        ListNode temp = head;
        while(fr <= lr && fc <= lc) {
            for(int i = fc;i <= lc;i++) {
                if(temp != null) arr[fr][i] = temp.val;
                else arr[fr][i] = -1;
                if(temp != null) temp = temp.next;
            }
            fr++;
            for(int i = fr;i <= lr;i++) {
                if(temp != null) arr[i][lc] = temp.val;
                else arr[i][lc] = -1;
                if(temp != null) temp = temp.next;
            }
            lc--;
            if(fr <= lr) {
                for(int i = lc;i >= fc;i--) {
                if(temp != null) arr[lr][i] = temp.val;
                else arr[lr][i] = -1;
                if(temp != null) temp = temp.next;
            }
            lr--;
            }
            if(fc <= lc) {
                for(int i = lr;i >= fr;i--) {
                if(temp != null) arr[i][fc] = temp.val;
                else arr[i][fc] = -1;
                if(temp != null) temp = temp.next;
            }
            fc++;
            }
        }
        return arr;
    }
}
