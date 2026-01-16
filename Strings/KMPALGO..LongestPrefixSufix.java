GFG
  Brute : TC and SC --> O(n^2)
    class Solution {
    int getLPSLength(String s) {
        String[] prefix = prefix(s);
        String[] suffix = suffix(s);
        int len = 0;
        int i = 0;
        int j = s.length() - 1;
        while(i < s.length() - 1 && j > 0) {
            if(prefix[i].equals(suffix[j])) len = i+1;
            i++;
            j--;
        }
        return len;
    }
    String[] prefix(String s) {
        String[] prefix = new String[s.length()];
        prefix[0] = "" + s.charAt(0);
        for(int i = 1;i < s.length(); i++) {
            prefix[i] = prefix[i-1] + s.charAt(i);
        }
        return prefix;
    }
    String[] suffix(String s) {
        String[] suffix = new String[s.length()];
        suffix[s.length() - 1] = "" + s.charAt(s.length() - 1);
        for(int i = s.length() - 2;i >= 0; i--) {
            suffix[i] = s.charAt(i) + suffix[i+1];
        }
        return suffix;
    }
}

Optimal :
  Using KMP Algorithm : TC AND SC : O(N)
    class Solution {
    int getLPSLength(String s) {
        //KMP Algorithm
        if(s.length() == 0 || s == null) return 0;
        int[] lps = new int[s.length()];
        int prefix = 0;
        int suffix = 1;
        while(suffix < s.length()) {
            //Match
            if(s.charAt(prefix) == s.charAt(suffix)) {//if found add it in lps array
                lps[suffix] = prefix + 1;
                prefix++;
                suffix++;
            }else {//Don't Match
                if(prefix == 0) {//if prefix is zero in this case their is no longest suffix and prefix exist hence just put 0 in lps array
                    lps[suffix] = 0;
                    suffix++;
                }else {
                    prefix = lps[prefix - 1];
                }
            }
        }
        return lps[s.length() - 1];
    }
}
