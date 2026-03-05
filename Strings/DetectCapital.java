Leetcode - 520
  class Solution {
    public boolean detectCapitalUse(String word) {
        int capitalCount = 0;
        boolean frstCapital = false;
        for(int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if(i == 0 && (ch >= 'A' && ch <= 'Z')) frstCapital = true;
            if(ch >= 'A' && ch <= 'Z') capitalCount++;
        }
        if(capitalCount == word.length()) return true;
        if(frstCapital && capitalCount == 1) return true;
        if(capitalCount == 0) return true;
        return false;
    }
}
