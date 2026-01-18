Leetcode - 686
  class Solution {
    public int repeatedStringMatch(String a, String b) {
        if(a.equals(b)) return 1;
        //add characters in string till we reaches b string size
        int rep = 1;
        StringBuilder sb = new StringBuilder(a);
        while(sb.length() < b.length()) {
            rep++;
            sb.append(a);
        }
        //KMP pattern search
        //Write the stringMatch function same as find first occueance of a string Leetcode 28
        if(stringMatch(sb,b) == 1) {
            return rep;
        }
        sb.append(a);
        if(stringMatch(sb,b) == 1) {
            return rep+1;
        }
        return -1;
    }
    public int stringMatch(StringBuilder sb,String b) {
        int n = sb.length();
        int m = b.length();
        if(n < m) return 0;
        //find lps
        int prefix = 0;
        int suffix = 1;
        int[] lps = new int[m];
        while(suffix < m) {
            if(b.charAt(prefix) == b.charAt(suffix)) {
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
        int first = 0;
        int second = 0;
        while(first < sb.length() && second < b.length()) {
            if(sb.charAt(first) == b.charAt(second)) {
                first++;
                second++;
            }else {
                if(second == 0) {
                    first++;
                }else {
                    second = lps[second - 1];
                }
            }
        }
        if(second == b.length()) return 1;
        else return 0;
    }
}
