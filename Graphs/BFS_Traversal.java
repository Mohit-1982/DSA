GFG
  class Solution {
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> res = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        set.add(0);
        while(!q.isEmpty()) {
            int front = q.remove();
            for(int num : adj.get(front)) {
                if(!set.contains(num)) {
                    q.add(num);
                    set.add(num);
                }
            }
            res.add(front);
        }
        return res;
    }
}
