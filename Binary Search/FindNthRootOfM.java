GFG
  Brute : O(n * logn) :
class Solution {
    public int nthRoot(int n, int m) {
        for(int i = 0;i<=m;i++) {
            if(Math.pow(i,n) == m) return i;
            else if(Math.pow(i,n) > m) break;
        }
        return -1;
    }
}

Optimal : O(n * logm) :
class Solution {
    public int nthRoot(int n, int m) {
        //O(n * logm)
        int s = 0;
        int e = m;
        while(s <= e) {
            int mid = s + (e - s) / 2;
            int pow = power(mid,n,m);
            if(pow == 1) {
                return mid;
            }else if(pow == 2) {
                e = mid - 1;
            }else {
                s = mid + 1;
            }
        }
        return -1;
    }
    //2 means greater then m search on left
    //1 means we got the answer return 
    //0 means its less then m search on right
    //this function will help in overflow error 
    public int power(int mid,int n,int m) {
        long ans = 1;
        for(int i = 1;i<=n;i++) {
            ans *= mid;
            if(ans > m) return 2;
        }
        if(ans == m) return 1;
        return 0;
    }
}
