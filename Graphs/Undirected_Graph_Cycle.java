GFG
  *BFS :
    class Pair{
    int currNode;
    int Parent;
    
    Pair(int currNode, int Parent) {
        this.currNode = currNode;
        this.Parent = Parent;
    }
}
class Solution {
    public boolean isCycle(int V, int[][] edges) {
        
        ArrayList<ArrayList<Integer>> adj = adjForm(edges, V);
        boolean[] vis = new boolean[V];
        
        for(int i = 0; i < V; i++) {
            if(!vis[i] && detect(adj, vis, i)) {
                return true;
            }
        }
        
        return false;
    }
    
    public boolean detect(ArrayList<ArrayList<Integer>> adj, boolean[] vis, int strt) {
        
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(strt, -1));
        vis[strt] = true;
        
        while(!q.isEmpty()) {
            Pair front = q.remove();
            int node = front.currNode;
            int parent = front.Parent;
            
            for(int adjNode : adj.get(node)) {
                if(!vis[adjNode]) {
                    q.add(new Pair(adjNode, node));
                    vis[adjNode] = true;
                }else if(parent != adjNode) {
                    return true;
                }
            }
        }
        
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
            adj.get(v).add(u);
        }
        
        return adj;
    }
}
*DFS : 
  class Solution {
    public boolean isCycle(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = adjForm(edges, V);
        boolean[] vis = new boolean[V];
        
        for(int i = 0; i < V; i++) {
            if(!vis[i]) {
                if(dfs(vis, adj, i, -1)) return true;
            }
        }
        
        return false;
    }
    
    public boolean dfs(boolean[] vis, ArrayList<ArrayList<Integer>> adj, int node, int parent) {
        
        vis[node] = true;
        
        for(int num : adj.get(node)) {
            if(!vis[num]) {
                if(dfs(vis, adj, num, node)) return true;
                //we cant do something like return dfs() because
                //this will just go to one path and will igonre every other paths
            }else if(parent != num) {
                return true;
            }
        }
        
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
            adj.get(v).add(u);
        }
        
        return adj;
    }
}
