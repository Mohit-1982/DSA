Leetcode - 409
class Solution {
    public int longestPalindrome(String s) {
        //if length is even we can take all characters but for
        //odd ones we can take odd char - 1 as the last character 
        //we can't take it to form pallindrome except the middle part 
        int n = s.length();
        HashMap<Character, Integer> map = new HashMap<>();

        for(int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if(map.containsKey(ch)) {
                int freq = map.get(ch);
                map.put(ch, freq + 1);
            }else {
                map.put(ch, 1);
            }
        }

        int len = 0;
        int oddLen = 0;
        boolean hasOdd = false;

        for(char ch : map.keySet()) {
            if(map.get(ch) % 2 == 0) {
                len += map.get(ch);
            }else {
                len += map.get(ch) - 1;
                hasOdd = true;
            }
        }
        //Some characters may have 1 leftover (from odd frequencies)
        //You can place exactly one of those leftovers in the center
        if(hasOdd) len++;

        return len;
    }
}
