Leetcode - 1758 
  Not Optimal 
  class Solution {
    public int minOperations(String s) {
        char[] arr = s.toCharArray();
        int count = 0;
        for(int i = 1; i < arr.length; i++) {
            if(arr[i] == arr[i - 1]) {
                if(arr[i] == '0') arr[i] = '1';
                else arr[i] = '0';
                count++;
            }
        }
        char[] arr1 = s.toCharArray();
        if(arr1[0] == '1') arr1[0] = '0';
        else arr1[0] = '1';
        int count2 = 1;//Counted the move for flipping the first character
        for(int i = 1; i < arr1.length; i++) {
            if(arr1[i] == arr1[i - 1]) {
                if(arr1[i] == '0') arr1[i] = '1';
                else arr1[i] = '0';
                count2++;
            }
        }
        return Math.min(count, count2);
    }
}
