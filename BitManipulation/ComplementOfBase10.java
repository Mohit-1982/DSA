Leetcode - 1009
  class Solution {
    public int bitwiseComplement(int n) {
        if(n == 0) return 1;
        int count = 0;
        int comp = 0;
        while(n != 0) {
            if((n & 1) == 0) {
                comp += Math.pow(2,count);
            }
            count++;
            n = n >> 1;
        }
        return comp;
    }
}
