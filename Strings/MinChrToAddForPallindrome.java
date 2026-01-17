GFG
  TC --> o(n)  SC --> O(n)
  class Solution {
    static int minChar(String s) {
        //using KMP Algorithm
        int n = s.length();
        //this will give TLE as we are reversing a string and strings are immutable so whole content is going to be copied again and new string is going to be created.
        //Hence, we have to use the stringbuilder
        StringBuilder sb = new StringBuilder();
        sb.append(s);
        // String rev = "";
        // for(int i = s.length() - 1;i >= 0; i--) {
        //     rev += s.charAt(i);
        // }
        sb.append('$');
        StringBuilder rev = new StringBuilder(s);
        rev.reverse();
        sb.append(rev);
        // s += '$';
        // s += sb;
        int prefix = 0;
        int suffix = 1;
        int[] lps = new int[sb.length()];
        while(suffix < sb.length()) {
            if(sb.charAt(prefix) == sb.charAt(suffix)) {
                lps[suffix] = prefix + 1;
                prefix++;
                suffix++;
            }else {
                if(prefix == 0) {
                    lps[suffix] = 0;
                    suffix++;
                }else {
                    prefix = lps[prefix - 1];
                }
            }
        }
        return n - lps[sb.length() - 1];
    }
}
