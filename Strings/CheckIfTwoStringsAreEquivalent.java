Leetcode - 1662
  Brute : 
    class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < word1.length; i++) {
            sb.append(word1[i]);
        }
        StringBuilder sb1 = new StringBuilder();
        for(int i = 0; i < word2.length; i++) {
            sb1.append(word2[i]);
        }
        if(sb.length() != sb1.length()) return false;
        int i = 0;
        int j = 0;
        // while(i < sb.length()) {
        //     if(sb.charAt(i) != sb1.charAt(j)) return false;
        //     i++;
        //     j++;
        // }
        // return true;
        return sb.toString().equals(sb1.toString());
    }
}

Optimal : 
  class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        int w1i = 0;
        int w2j = 0;
        int i = 0;
        int j = 0;
        while(w1i < word1.length && w2j < word2.length) {
            if(word1[w1i].charAt(i) != word2[w2j].charAt(j)) {
                return false;
            }
            i++;
            j++;
            if(i == word1[w1i].length()) {
                i = 0;
                w1i++;
            }
            if(j == word2[w2j].length()) {
                j = 0;
                w2j++;
            }
        }
        return w1i == word1.length && w2j == word2.length;
    }
}
