GFG

//Little bit wrong code try to find the errors in this question 
//First read question then find the error

class Solution {
    public int longestKSubstr(String s, int k) {
        int l = 0;
        int r = 0;
        int maxLen = 0;
        int isK = 0;
        HashMap<Character,Integer> map = new HashMap<>();
        while(r < s.length()) {
            if(map.containsKey(s.charAt(r))) {
                int freq = map.get(s.charAt(r)) + 1;
                map.put(s.charAt(r),freq);
            }else map.put(s.charAt(r),1);
            if(map.size() == k) isK = 1;
            if(map.size() > k) {
                isK = 1;
                int freq = map.get(s.charAt(l)) - 1;
                if(freq == 0) map.remove(s.charAt(l));
                else map.put(s.charAt(l),freq);
                l++;
            }
            if(map.size() <= k) {
                maxLen = Math.max(maxLen,r-l+1);
            }
            r++;
        }
        if(isK == 0) return -1;
        return maxLen;
    }
}
