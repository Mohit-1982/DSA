GFG
  class Solution {
    public boolean isCyclic(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = adjForm(edges, V);
        boolean[] vis = new boolean[V];
        boolean[] pathVis = new boolean[V];
        
        for(int i = 0; i < V; i++) {
            if(!vis[i]) {
                if(dfs(adj, vis, pathVis, i)) return true; 
            }
        }
        
        return false;
    }
    
    public boolean dfs(ArrayList<ArrayList<Integer>> adj, boolean[] vis, boolean[] pathVis, int node) {
        vis[node] = true;
        pathVis[node] = true;
        
        for(int vertex : adj.get(node)) {
            if(!vis[vertex]) {
                if(dfs(adj, vis, pathVis, vertex)) return true;
            }
            else if(pathVis[vertex]) return true;
        }
        
        pathVis[node] = false;
        return false;
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
