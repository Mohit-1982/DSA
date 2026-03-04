Leetcode - 1704
  class Solution {
    public boolean halvesAreAlike(String s) {
        int i = 0;
        int iend = s.length() / 2;
        int j = s.length() / 2;
        int ivowel = 0;
        int jvowel = 0;
        while(i < iend) {
            char ch = s.charAt(i);
            char dh = s.charAt(j);
            if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U') ivowel++;
            if(dh == 'a' || dh == 'e' || dh == 'i' || dh == 'o' || dh == 'u' || dh == 'A' || dh == 'E' || dh == 'I' || dh == 'O' || dh == 'U') jvowel++;

            i++;
            j++;
        }
        return ivowel == jvowel;
    }
}
