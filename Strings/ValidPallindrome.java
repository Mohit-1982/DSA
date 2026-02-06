Leetcode - 125
  class Solution {
    public boolean isPalindrome(String s) {
        //better to create a function of checking these special characters
        int i = 0;
        int j = s.length() - 1;
        while(i < j) {
            char chi = s.charAt(i);
            char chj = s.charAt(j);
            if((chi >= ' ' && chi <= '/') || (chi >= ':' && chi <= '@') || (chi >= '[' && chi <= '`') || (chi >= '{' && chi <= '~')) {
                i++;
            }else if((chj >= ' ' && chj <= '/') || (chj >= ':' && chj <= '@') || (chj >= '[' && chj <= '`') || (chj >= '{' && chj <= '~')) {
                j--;
            }else {
                if(chi >= 'A' && chi <= 'Z') {
                    chi += 32;
                }
                if(chj >= 'A' && chj <= 'Z') {
                    chj += 32;
                }
                if(chi == chj) {
                    i++;
                    j--;
                }else {
                    return false;
                }
            }
        }
        return true;
    }
}
