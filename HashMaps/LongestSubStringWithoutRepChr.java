Leetcode - 3
//HashSet + Sliding Window
  class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0) return 0;
        HashSet<Character> set = new HashSet<>();
        int i = 0;
        int j = 0;
        int maxLen = 1;
        while(j < s.length()) {
            if(!set.contains(s.charAt(j))) {
                set.add(s.charAt(j));
                j++;
            }
            else {
                int len = j - i;
                maxLen = Math.max(maxLen,len);
                while(s.charAt(i) != s.charAt(j)) {
                    set.remove(s.charAt(i));
                    i++;
                }
                i++;
                j++;
            }
        }
        int len = j - i;
        maxLen = Math.max(maxLen,len);
        return maxLen;
    }
}
