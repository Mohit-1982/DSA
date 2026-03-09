Leetcode - 387
  Brute : 
    class Solution {
    public int firstUniqChar(String s) {
        for(int i = 0; i < s.length(); i++) {
            boolean isFound = false;
            for(int j = 0; j < s.length(); j++) {
                if(i == j) continue;
                if(s.charAt(i) == s.charAt(j)) {
                    isFound = true;
                    break;
                }
            }
            if(!isFound) return i;
        }
        return -1;
    }
}
Optimal : 
  class Solution {
    public int firstUniqChar(String s) {
        int[] arr = new int[26];
        for(int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a']++;
        }
        for(int i = 0; i < s.length(); i++) {
            if(arr[s.charAt(i) - 'a'] == 1) return i;
        }
        return -1;
    }
}
