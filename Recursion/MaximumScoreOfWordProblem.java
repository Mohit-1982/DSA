public class MaximumScoreOFWordProblem {
    public static void main(String[] args) {
        String[] words = {"dog","cat","dad"}; //,"dad","good"
        int[] freqArr = {1,1,1,3,0,0,1,0,0,0,0,0,0,0,2,0,0,0,0,0,0,0,0,0,0,0};
        int[] scores =  {1,0,9,5,0,0,3,0,0,0,0,0,0,0,2,0,0,0,0,0,0,0,0,0,0,0};
        int ans = maxScore(words,freqArr,scores,0);
        System.out.println(ans);
    }
    static int maxScore(String[] words,int[] freqArr,int[] scores,int idx) {
        if(idx == words.length) {
            return 0;
        }
        int scoreNotIncluded = maxScore(words,freqArr,scores,idx + 1);//word not included

        //word to include
        int sword = 0;
        String word = words[idx];
        boolean flag = true;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if(freqArr[ch - 'a'] == 0) {
                flag = false;
            }
            freqArr[ch - 'a']--;//here if frequency becomes negative so need to worry as we are not going to return
            //this in our answer as flag will become false, and it won't add in syes and return sno value only
            //in this case syes will be 0
            sword += scores[ch - 'a'];
        }
        int syes = 0;
        if(flag) {
            syes += sword + maxScore(words,freqArr,scores,idx + 1);
        }
        for(int i = 0;i < word.length();i++) { //backTrack making the frequency increase which we have decreased earlier
            char ch = word.charAt(i);
            freqArr[ch - 'a']++;
        }
        return Math.max(syes,scoreNotIncluded);
    }
}
