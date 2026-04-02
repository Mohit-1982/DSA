GFG
  class Solution {
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> res = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        dfs(adj, res, 0, set);
        return res;
    }
    public void dfs(ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> res, int node, HashSet<Integer> set) {
        set.add(node);
        res.add(node);
        for(int num : adj.get(node)) {
            if(!set.contains(num)) dfs(adj, res, num, set);
        }
    }
}
