GFG
  *DFS:
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

Kahn's Algorithm 
  BFS:
    In Kahn’s Algorithm, indegree does not go below zero because each edge contributes exactly one increment and one decrement.
  Since every node is processed once and every edge is processed once, the total decrements match the increments.

  class Solution {
    public ArrayList<Integer> topoSort(int V, int[][] edges) {
        ArrayList<Integer> res = new ArrayList<>();
        ArrayList<ArrayList<Integer>> adj = adjForm(edges, V);
        
        int[] indegree = new int[V];
        
        for(int i = 0; i < adj.size(); i++) {
            for(int j = 0; j < adj.get(i).size(); j++) {
                indegree[adj.get(i).get(j)]++;
            }
        }
        
        Queue<Integer> q = new LinkedList<>();
        
        for(int i = 0; i < indegree.length; i++) {
            if(indegree[i] == 0) q.add(i);
        }
        
        while(!q.isEmpty()) {
            int front = q.remove();
            res.add(front);
            
            for(int node : adj.get(front)) {
                indegree[node]--;
                if(indegree[node] == 0) q.add(node);
            }
        }
        
        return res;
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
