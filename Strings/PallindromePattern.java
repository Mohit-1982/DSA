GFG
  class Solution {
    public List<String> all_palindromes(String s) {
        //first count all the frequencies
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i = 0;i < s.length();i++) {
            char ch = s.charAt(i);
            if(map.containsKey(ch)) {
                int freq = map.get(ch);
                map.put(ch,freq + 1);
            }else {
                map.put(ch,1);
            }
        }
        //now make all the freq half
        int count0 = 0;
        Character occurOne = null;
        int len = 0;
        for(char ele : map.keySet()) {
            int get = map.get(ele);
            if(get % 2 == 1) {
                count0++;
                occurOne = ele;
            }
            map.put(ele,get/2);
            len += get / 2;
        }
        if(count0 > 1) return new ArrayList<>();
        List<String> list = new ArrayList<>();
        makePalli(1,len,list,map,occurOne,"");
        Collections.sort(list);
        return list;
    }
    public String revString(String ans) {
        String res = "";
        for(int i = ans.length() - 1;i >= 0 ;i--) {
            res += ans.charAt(i);
        }
        return res;
    }
    public void makePalli(int curr,int total,List<String> list,HashMap<Character,Integer> map,Character occurOne,String ans) {
        if(curr > total) {
            String res = "";
            String rev = revString(ans);
            res += ans;
            if(occurOne != null) {
                res += occurOne;
            }
            res += rev;
            list.add(res);
            return;
        }
        for(char ele : map.keySet()) {
            int freq = map.get(ele);
            if(freq > 0) {
                map.put(ele,freq - 1);
                makePalli(curr + 1,total,list,map,occurOne,ans + ele);
                map.put(ele,freq);
            }
        }
    }
}
