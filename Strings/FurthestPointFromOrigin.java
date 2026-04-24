Leetcode - 2833
  Brute : 
    class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int dist = 0;
        int n = moves.length();

        int lCount = 0;
        int rCount = 0;

        for (int i = 0; i < n; i++) {
            if (moves.charAt(i) == 'L') {
                lCount++;
            }else if(moves.charAt(i) == 'R') {
                rCount++;
            }
        }

        for (int i = 0; i < n; i++) {
            if (moves.charAt(i) == 'L') {
                dist--;
            }else if (moves.charAt(i) == 'R') {
                dist++;
            }else {
                if (lCount > rCount) dist--;
                else dist++;
            }
        }

        return Math.abs(dist);
    }
}

Optimal :  
  class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int left = 0;
        int right = 0;
        int blank = 0;
        int n = moves.length();

        for (int i = 0; i < n; i++) {
            char ch = moves.charAt(i);

            if (ch == 'L') left++;
            else if (ch == 'R') right++;
            else blank++;
        }
        //because at last we gets the absolute value so
        //we just need to sub left and right because whoever the bigger one is always going to add blank in it
        return Math.abs(left - right) + blank;
    }
}
