Leetcode - 443
  Brute : O(n) and O(n) space
    class Solution {
    public int compress(char[] arr) {
        if(arr.length == 1) return 1;
        StringBuilder sb = new StringBuilder();
        int i = 0;
        int j = 0;
        while(j < arr.length) {
            while(j < arr.length && arr[j] == arr[i]) {
                j++;
            }
            int freq = j - i;
            sb.append("" + arr[i]);
            if(freq != 1) sb.append("" + freq);
            i = j;
        }
        for(int k = 0; k < sb.length(); k++) {
            arr[k] = sb.charAt(k);
        }
        return sb.length();
    }
}

Optimal : By maintaing some pointers
  class Solution {
    public int compress(char[] arr) {
        if(arr.length == 1) return 1;
        int n = arr.length;
        int idx = 0;
        int i = 0;
        while(i < arr.length) {
            char curr_char = arr[i];
            int count = 0;
            while(i < arr.length && arr[i] == curr_char) {
                i++;
                count++;
            }
            //Assign
            arr[idx] = curr_char;
            idx++;
            if(count > 1) {
                String s = "" + count;
                for(int k = 0; k < s.length(); k++) {
                    arr[idx++] = s.charAt(k);
                }
            }
        }
        return idx;
    }
}
