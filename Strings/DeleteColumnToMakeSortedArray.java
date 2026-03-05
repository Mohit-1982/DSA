Leetcode - 944
  class Solution {
    public int minDeletionSize(String[] strs) {
        //all the strings are of equal length
        if(strs.length == 1) return 0;
        int delete = 0;
        int n = strs.length;
        int m = strs[0].length(); 
        for(int col = 0; col < m; col++) {
            for(int row = 1; row < n; row++) {
                if(strs[row].charAt(col) < strs[row - 1].charAt(col)) {
                    delete++;
                    break;
                }
            }
        } 
        return delete;
    }
}
