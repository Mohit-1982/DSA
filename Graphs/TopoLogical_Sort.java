GFG
  class Solution {
    public ArrayList<Integer> topoSort(int V, int[][] edges) {
        boolean[] vis = new boolean[V];
        Stack<Integer> st = new Stack<Integer>();
        ArrayList<Integer> res = new ArrayList<>();
        ArrayList<ArrayList<Integer>> list = adjForm(edges, V);
        
        for(int i = 0; i < V; i++) {
            if(!vis[i]) {
                dfs(list, st, i, vis);
            }
        }
        
        while(!st.isEmpty()) {
            res.add(st.pop());
        }
        
        return res;
    }
    public void dfs(ArrayList<ArrayList<Integer>> list, Stack<Integer> st, int node, boolean[] vis) {
        
        vis[node] = true;
        
        for(int ele : list.get(node)) {
            if(!vis[ele]) {
                dfs(list, st, ele, vis);
            }
        }
        
        st.push(node);
    }
    
    public ArrayList<ArrayList<Integer>> adjForm(int[][] arr, int V) {
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for(int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        
        for(int i = 0; i < arr.length; i++) {
            int u = arr[i][0];
            int v = arr[i][1];
            
            adj.get(u).add(v);
        }
        
        return adj;
    }
}
