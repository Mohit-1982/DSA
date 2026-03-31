Leetcode - 763
  class Solution {
    public List<Integer> partitionLabels(String s) {
        int n = s.length();

        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            map.put(s.charAt(i), i);
        }

        int i = 0;
        int prev = i;
        int j = map.get(s.charAt(0));
        List<Integer> list = new ArrayList<>();

        while(i < n) {
            j = Math.max(j, map.get(s.charAt(i)));
            if(i == j) {
                list.add(j - prev + 1);
                prev = i + 1;
            }
            i++;
        }
        return list;
    }
}
