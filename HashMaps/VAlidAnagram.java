Neetcode 
  class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;

        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        HashMap<Character, Integer> map1 = new HashMap<>();
        for(int i = 0; i < t.length(); i++) {
            map1.put(t.charAt(i), map1.getOrDefault(t.charAt(i), 0) + 1);
        }

        if(map.size() != map1.size()) return false;

        for(char ch : map.keySet()) {
            if(!map.get(ch).equals(map1.get(ch))) return false; //it gives integer so we have to check using .equals otherwise memory of integer is going to be compared
        }
        
        return true;
    }
}
