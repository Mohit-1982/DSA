class Solution {
    public List<String> AllPossibleStrings(String s) {
        List<String> list = new ArrayList<>();
        allPossible(s,"",list);
        Collections.sort(list);
        return list;
    }
    public void allPossible(String up,String p,List<String> list) {
        if(up.isEmpty()) {
            if(!p.isEmpty()) list.add(p);
            return;
        }
        //pick
        char ch = up.charAt(0);
        allPossible(up.substring(1),p + ch,list);
        //dont pick
        allPossible(up.substring(1),p,list);
    }
}
