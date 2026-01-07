GFG

  class Sol {
    long equalPairs(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            if(map.containsKey(s.charAt(i))) {
                int freq = map.get(s.charAt(i));
                map.put(s.charAt(i),freq + 1);
            }else map.put(s.charAt(i),1);
        }
        long count = 0;
        for(char ele : map.keySet()) {
            int f = map.get(ele);
            count = count + (long)f*f;
        }
        return count;
    }
}
