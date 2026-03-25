Leetcode - 744
  Brute : 
    class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        char res = '{'; //char res = (char)('z' + 1);
        int n = letters.length;
        for(int i = 0; i < n; i++) {
            if(letters[i] > target && letters[i] < res) res = letters[i]; 
        }
        return (res != '{') ? res : letters[0];
    }
}
Optimal : 
  class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int n = letters.length;
        int s = 0;
        int e = n - 1;
        char res = (char)('z' + 1);
        while(s <= e) {
            int m = s + (e - s) / 2;
            if(letters[m] <= target) {
                s = m + 1;
            }else {
                if(res > letters[m]) res = letters[m];
                e = m - 1;
            }
        }
        return (res <= 'z') ? res : letters[0];
    }
}
*More Cleaner :
  class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int n = letters.length;
        int s = 0;
        int e = n - 1;
        while(s <= e) {
            int m = s + (e - s) / 2;
            if(letters[m] <= target) {
                s = m + 1;
            }else {
                e = m - 1;
            }
        }
        return letters[s % n];
    }
}
