Leetcode - 66
  Brute : 
    class Solution {
    public int[] plusOne(int[] digits) {
        ArrayList<Integer> list = new ArrayList<>();
        int carry = 1;
        for(int i = digits.length - 1; i >= 0; i--) {
            int sum = carry + digits[i];
            list.add(0, sum % 10);
            if(sum > 9) carry = 1;
            else carry = 0;
        }
        if(carry == 1) list.add(0, carry);
        int[] arr = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }
}

OPtimal : 
  class Solution {
    public int[] plusOne(int[] digits) {
        for(int i = digits.length - 1; i >= 0; i--) {
            if(digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        int[] arr = new int[digits.length + 1];
        arr[0] = 1;
        return arr;
    }
}
