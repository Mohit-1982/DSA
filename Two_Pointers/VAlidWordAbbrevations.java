Neetcode 
  class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        int n = word.length();
        int m = abbr.length();
        int i = 0;
        int j = 0;
        while(i < n && j < m) {

            if(word.charAt(i) == abbr.charAt(j)) {
                i++;
                j++;
            }else if(abbr.charAt(j) >= '0' && abbr.charAt(j) <= '9') {
                int num = 0;
                if(abbr.charAt(j) == '0') return false; //Leading Zeroes or Num is Zero
                while(j < m && (abbr.charAt(j) >= '0' && abbr.charAt(j) <= '9')) {
                    num = num * 10 + (abbr.charAt(j) - '0');
                    j++;
                }
                i += num;
                if(i > n) return false;//Num is larger than the length of word
            }else {
                return false;
            }
        }
        return i == n && j == m;
    }
}
