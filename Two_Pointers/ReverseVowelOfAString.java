Leetcode - 345
  Brute : 
    class Solution {
    public String reverseVowels(String s) {
        StringBuilder sb = new StringBuilder(s);
        ArrayList<Character> list = new ArrayList<>();
        for(int i = 0; i < sb.length(); i++) {
            if(isVowel(sb.charAt(i))) list.add(sb.charAt(i));
        }
        int j = list.size() - 1;
        for(int i = 0; i < sb.length(); i++) {
            if(isVowel(sb.charAt(i))) {
                sb.setCharAt(i, list.get(j));
                j--;
            }
        }
        return sb.toString();
    }
    public boolean isVowel(char ch) {
        if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') return true;
        if(ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U') return true;
        return false;
    }
}
Optimal : 
  class Solution {
    public String reverseVowels(String s) {
        StringBuilder sb = new StringBuilder(s);
        int i = 0;
        int j = sb.length() - 1;
        while(i < j) {
            while(i < j && !isVowel(sb.charAt(i))) i++;
            while(i < j && !isVowel(sb.charAt(j))) j--;
            char atI = sb.charAt(i);
            sb.setCharAt(i, sb.charAt(j));
            sb.setCharAt(j, atI);
            i++;
            j--;
        }
        return sb.toString();
    }
    public boolean isVowel(char ch) {
        if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') return true;
        if(ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U') return true;
        return false;
    }
}
