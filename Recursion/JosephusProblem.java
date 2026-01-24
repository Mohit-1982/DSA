GFG
  //1 based indexing
  //for zero based indexing use y = (x + k) % n ans base case n == 1 return 0;
  class Solution {
    public int josephus(int n, int k) {
        if(n == 1) {
            return 1;
        }
        int x = josephus(n - 1,k);
        int y = (x + k - 1) % n + 1;
        return y;
    }
}
