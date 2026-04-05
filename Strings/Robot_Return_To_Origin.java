Leetcode - 657
  class Solution {
    public boolean judgeCircle(String s) {
        int x = 0;
        int y = 0;
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(ch == 'U') y++;
            else if(ch == 'D') y--;
            else if(ch == 'L') x--;
            else x++;
        }
        return (x == 0) && (y == 0);
    }
}
