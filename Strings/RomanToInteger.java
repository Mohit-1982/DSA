Leetcode - 13
  OverComplicated - Many if else chain 
    class Solution {
    public int romanToInt(String s) {
        int convert = 0;
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            char chNext = 0;
            int check = 0;
            if(i < s.length() - 1) {
                chNext = s.charAt(i + 1);
            }
            if(ch == 'I' && chNext == 'V') check = 1;
            else if(ch == 'I' && chNext == 'X') check = 1;
            else if(ch == 'X' && chNext == 'L') check = 1;
            else if(ch == 'X' && chNext == 'C') check = 1;
            else if(ch == 'C' && chNext == 'D') check = 1;
            else if(ch == 'C' && chNext == 'M') check = 1;

            if(i < s.length() - 1 && check == 1) {
                if(ch == 'I' && s.charAt(i+1) == 'V') convert += 4;
                else if(ch == 'I' && s.charAt(i+1) == 'X') convert += 9;
                else if(ch == 'V' && s.charAt(i+1) == 'X') convert += 9;
                else if(ch == 'X' && s.charAt(i+1) == 'L') convert += 40;
                else if(ch == 'X' && s.charAt(i+1) == 'C') convert += 90;
                else if(ch == 'C' && s.charAt(i+1) == 'D') convert += 400;
                else convert += 900;
                check = 0;
                i++;
            }else {
                if(ch == 'I') convert += 1;
                else if(ch == 'V') convert += 5;
                else if(ch == 'X') convert += 10;
                else if(ch == 'L') convert += 50;
                else if(ch == 'C') convert += 100;
                else if(ch == 'D') convert += 500;
                else convert += 1000;
            }
        }
        return convert;
    }
}

Optimal :
class Solution {
    public int romanToInt(String s) {
        int i = 0;
        int ans = 0;
        while(i < s.length() - 1) {
            char ch = s.charAt(i);
            char chNext = s.charAt(i+1);
            int geti = getValue(ch);
            int getiP = getValue(chNext);
            if(geti >= getiP) {
                ans += geti;
            }else {
                ans -= geti;
            }
            i++;
        }
        ans += getValue(s.charAt(i));
        return ans;
    }
    public int getValue(char a) {
        //Better to use Switch here for easy read
        if(a == 'I') return 1;
        else if(a == 'V') return 5;
        else if(a == 'X') return 10;
        else if(a == 'L') return 50;
        else if(a == 'C') return 100;
        else if(a == 'D') return 500;
        else return 1000;
    }
}
  
