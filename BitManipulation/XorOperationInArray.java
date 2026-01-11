Approach 1 :

class Solution {
    public int xorOperation(int n, int start) {
        int[] arr = new int[n];
        for(int i = 0;i<arr.length;i++) {
            arr[i] = start + (2*i);
        }
        int ans = 0;
        for(int i = 0;i<arr.length;i++) {
            ans ^= arr[i]; 
        }
        return ans;
    }
}

Approach 2 : without using array

  class Solution {
    public int xorOperation(int n, int start) {
        int ans = 0;
        for(int i = 0;i<n;i++) {
            ans ^= (start + (2*i));
        }
        return ans;
    }
}

Approach 3 : For GFG only
//we will find xor from 1 to l -1 and then xor it with 1 to r xor it will cancel or starting ones which is not needed.
  //1^2^3^4^5^6^7^8^1^2^3 = 4^5^6^7^8.
  class Solution {
    public static int findXOR(int l, int r) {
        return xor(r) ^ xor(l-1);
    }
    public static int xor(int n) {
        if(n % 4 == 1) return 1;
        else if(n % 4 == 2) return n + 1;
        else if(n % 4 == 3) return 0;
        else return n;
    }
}

