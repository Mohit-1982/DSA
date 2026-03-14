Leetcode - 917
  class Solution {
    public String reverseOnlyLetters(String str) {
        //Better to use str.toCharArray
        int i = 0;
        int j = str.length() - 1;
        StringBuilder s = new StringBuilder(str);
        while(i < j) {
            char ch = s.charAt(i);
            char bh = s.charAt(j);
            boolean aTrue = true;
            boolean bTrue = true;
            if(!isAlpha(ch)) {
                i++;
                aTrue = false;
            }
            if(!isAlpha(bh)) {
                j--;
                bTrue = false;
            }
            if(aTrue && bTrue) {
                s.setCharAt(i, bh);
                s.setCharAt(j, ch);
                i++;
                j--;
            }
        }
        return s.toString();
    }
    public boolean isAlpha(char ch) {
        boolean chance1 = false;
        boolean chance2 = false;
        if(ch >= 'a' && ch <= 'z') chance1 = true;
        if(ch >= 'A' && ch <= 'Z') chance2 = true;
        return chance1 || chance2;
    }
}
