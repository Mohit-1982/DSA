Leetcode - 38
  class Solution {
    public String countAndSay(int n) {
        if(n == 1) return "1";
        String s = countAndSay(n - 1);
        String str = "";
        int i = 0;
        int j = 0;
        while(j < s.length()) {
            int count = 0;
            while(j < s.length() && s.charAt(i) == s.charAt(j)) {
                j++;
                count++;
            }
            str += count;
            str += s.charAt(i);
            i = j;
        }
        return str;
    }
}
