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

*BFS --> Kahn's Algorithm
  class Solution {
    public boolean isCyclic(int V, int[][] edges) {
        //Kahn's Algorithm BFS
        ArrayList<ArrayList<Integer>> adj = adjForm(edges, V);
        int[] indeg = new int[V];
        
        for (int i = 0; i < adj.size(); i++) {
            for (int j = 0; j < adj.get(i).size(); j++) {
               indeg[adj.get(i).get(j)]++; 
            }
        }
        
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();
        
        for (int i = 0; i < V; i++) {
            if (indeg[i] == 0) {
                list.add(i);
                q.add(i);
            }
        }
        
        while (!q.isEmpty()) {
            int front = q.remove();
            
            for(int node : adj.get(front)) {
                indeg[node]--;
                
                if (indeg[node] == 0) {
                    list.add(node);
                    q.add(node);
                }
            }
        }
        
        return (list.size() == V) ? false : true;
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
