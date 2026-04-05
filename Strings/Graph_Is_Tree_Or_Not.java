GFG
  class Pair{
    int currNode;
    int parent;
    
    Pair(int currNode, int parent) {
        this.currNode = currNode;
        this.parent = parent;
    }
}
class Solution {
    public boolean isTree(int n, int m, ArrayList<ArrayList<Integer>> edges) {
        ArrayList<ArrayList<Integer>> adj = adjForm(edges, n);
        boolean[] vis = new boolean[n];
        int connectedComp = 0;
        
        for(int i = 0; i < n; i++) {
            if(!vis[i]) {
                if(bfs(adj, vis, i)) return false;
                connectedComp++;
            }
            if(connectedComp > 1) return false;
        }
        
        return true;
    }
    
    public boolean bfs(ArrayList<ArrayList<Integer>> adj, boolean[] vis, int node) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(node, -1));
        vis[node] = true;
        
        while(!q.isEmpty()) {
            //Parent-Child tracking
            Pair front = q.remove();
            int curr = front.currNode;
            int parent = front.parent;
            
            for(int adjNode : adj.get(curr)) {
                if(!vis[adjNode]) {
                    q.add(new Pair(adjNode, curr));
                    vis[adjNode] = true;
                }else if(parent != adjNode) {
                    return true;
                }
            }
        }
        
        return false;
    }
    
    public ArrayList<ArrayList<Integer>> adjForm(ArrayList<ArrayList<Integer>> arr, int n) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for(int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        
        for(int i = 0; i < arr.size(); i++) {
            int u = arr.get(i).get(0);
            int v = arr.get(i).get(1);
            
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        
        return adj;
    }
}
