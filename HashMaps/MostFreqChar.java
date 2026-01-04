class Solution {
    public char getMaxOccuringChar(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i = 0;i<s.length();i++) {
            if(map.containsKey(s.charAt(i))) {
                int freq = map.get(s.charAt(i));
                map.put(s.charAt(i),freq+1);
            }else map.put(s.charAt(i),1);
        }
        int max = 0;
        char ch = 'z';
        for(char ele : map.keySet()) {
                int val = map.get(ele);
                if(val > max) {
                    max = val;
                    ch = ele;
                }else if (val == max && ele < ch) {
                    ch = ele;
                }
            }
        return ch;
    }
}
