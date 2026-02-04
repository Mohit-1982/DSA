Leetcode - 1255
  class Solution {
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        //find the freq of letters
        int[] freqArr= new int[26];
        for(int i = 0;i < letters.length;i++) {
            char ch = letters[i];
            freqArr[ch - 'a']++;
        }
        return maxScore(words,freqArr,score,0);
    }
    public int maxScore(String[] words,int[] freqArr,int[] score,int idx) {
        if(idx == words.length) {
            return 0;
        }
        //Not Included
        int notInc = maxScore(words,freqArr,score,idx + 1);
        //Included
        //Check the word that its freq is equal or less than or greater than the frrArr
        int scoreOfWord = 0;
        String str = words[idx];
        boolean flag = true;
        for(int i = 0;i < str.length();i++) {
            char ch = str.charAt(i);
            if(freqArr[ch - 'a'] == 0) {
                flag = false;
            }
            scoreOfWord += score[ch - 'a'];
            freqArr[ch - 'a']--;
        }
        int sYes = 0;
        if(flag) {
            sYes = scoreOfWord + maxScore(words,freqArr,score,idx + 1);
        }
        //Add the freq in array which we have removed
        //BackTrack
        for(int i = 0;i < str.length();i++) {
            char ch = str.charAt(i);
            freqArr[ch - 'a']++;
        }
        return Math.max(sYes,notInc);
    }
}
