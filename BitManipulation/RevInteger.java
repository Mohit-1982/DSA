Leetcode - 7
  class Solution {
    public int reverse(int x) {
        if(x < 10 && x >= 0) return x;
        //Here we are not using sign = -1 and then multiply it with number because for Int.MIN value it is
        //-2147483648 * -1 ==> 2147483648 this will overflow the int Max Range hence this intuition is wrong.
        long ans=0;
        while(x != 0){
            int rem = x%10;
            ans = ans*10 + rem;//here we have to check for int overflow as reverse of a number can exceed the range of
            //int max to int min.
            if(ans < Integer.MIN_VALUE || ans > Integer.MAX_VALUE) return 0;
            x /= 10;
        }
        return (int)ans;
    }
}
