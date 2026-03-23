Leetcode - 190
  Brute : 
    class Solution {
    public int reverseBits(int n) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 32; i++) {
            sb.append("" + ((n >> i) & 1));
        }
        int i = sb.length() - 1;
        int res = 0;
        int count = 0;
        while(i >= 0) {
            if(sb.charAt(i) == '1') {
                res += Math.pow(2, count);
            }
            count++;
            i--;
        }
        return res;
    }
}
Better : 
  class Solution {
    public int reverseBits(int n) {
        int res = 0;
        int count = 0;
        for(int i = 31; i >= 0; i--) {
            if(((n >> i) & 1) == 1) {
                res += Math.pow(2, count);
            }
            count++;
        }
        return res;
    }
}
Optimal : 
  
