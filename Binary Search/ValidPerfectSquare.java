Leetcode - 367
  Brute :
   class Solution {
    public boolean isPerfectSquare(int num) {
        for(long i = 1;i <= num;i++) {
            if(i*i == num) return true;
            if(i*i > num) return false; 
        }
        return false;
    }
}

Optimal :
  class Solution {
    public boolean isPerfectSquare(int num) {
        int s = 1;
        int e = num;
        while(s <= e) {
            int m = s + (e - s) / 2;
            if((long)m * m == num) {
                return true;
            }else if ((long)m * m > num) {
                e = m - 1;
            }else {
                s = m + 1;
            }
        }
        return false;
    }
}
