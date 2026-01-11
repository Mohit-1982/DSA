Leetcode - 231

  Approach 1 :

class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n <= 0) return false;
        while(n%2==0) {
            n /= 2;
        }
        if(n == 1) return true;
        else return false;
    }
}

Approach 2 :

        class Solution {
    public boolean isPowerOfTwo(int n) {
        int[] arr = new int[32];
        arr[0] = 1;
        int power = 2;
        for(int i = 1;i <= 31;i++) {
            power = (int)Math.pow(2,i);
            arr[i] = power;
        }
        for(int i = 0;i<31;i++) {
            if(arr[i] == n) return true;
            if(arr[i] > n) return false;
        }
        return false;
    }
}

Approach 3 :

class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n <= 0) return false; 
        int count = 0;
        while(n > 0) {
            if((n & 1) == 1) count++;
            if(count > 1) return false;
            n = n >> 1;
        }
        return true;
    }
}

Approach 4 : 

class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n == 0) return false;
        if(n == 1) return true;
        if(n % 2 == 1) return false;
        return isPowerOfTwo(n/2);
    }
}

Approach 5 : Optimal Approach 
class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n <= 0) return false;
        return (n & (n-1)) == 0;
    }
}
