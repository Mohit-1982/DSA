Leetcode - 838
  Brute : 
    class Solution {
    public String pushDominoes(String s) {
        if(s.length() == 1) return s;
        int n = s.length();
        StringBuilder sb = new StringBuilder(s);
        
        //Leading Dots
        int i = 0;
        if(sb.charAt(i) == '.') {
            while(i < n && sb.charAt(i) == '.') i++;
            if(i == n) return s;
            if(sb.charAt(i) == 'L') {
                for(int k = 0; k < i; k++) {
                    sb.setCharAt(k, 'L');
                }
            }
        }

        //Trailing Dots
        int j = n - 1;
        if(sb.charAt(j) == '.') {
            while(j >= 0 && sb.charAt(j) == '.') j--;
            if(j == -1) return s;
            if(sb.charAt(j) == 'R') {
                for(int k = j + 1; k < n; k++) {
                    sb.setCharAt(k, 'R');
                }
            }
        }

        //Center Part
        while(i < j) {
            if(sb.charAt(i) == '.') {
                int st = i;
                while(st < n && sb.charAt(st) == '.') st++;
                int e = st - 1;

                char left = (i > 0) ? sb.charAt(i - 1) : 'L';
                char right = (st < n) ? sb.charAt(st) : 'R';

                //Case 1 : 
                    if(left == 'R' && right == 'L') {
                        int l = i, r = e;
                        while(l < r) {
                            sb.setCharAt(l++, left);
                            sb.setCharAt(r--, right);
                        }
                    }else if(left == 'L' && right == 'L') {
                        for(int k = i; k <= e; k++) {
                            sb.setCharAt(k, 'L');
                        }
                    }else if(left == 'R' && right == 'R') {
                        for(int k = i; k <= e; k++) {
                            sb.setCharAt(k, 'R');
                        }
                    }
                    i = st;
            }else {
                i++;
            }
        }

        return sb.toString();
    }
}

Optimal : 
  
