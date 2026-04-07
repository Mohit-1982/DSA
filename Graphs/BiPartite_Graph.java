Leetcode - 785
  *BFS : 
    class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        Arrays.fill(color, -1);
        Queue<Integer> q = new LinkedList<>();

        for(int k = 0; k < n; k++) {
            if(color[k] != -1) continue;

            q.add(k);
            color[k] = 0;

            while(!q.isEmpty()) {
            int node = q.remove();

            for(int i = 0; i < graph[node].length; i++) {
                int neighbour = graph[node][i];
                if(color[neighbour] == -1) {
                    q.add(neighbour);
                    color[neighbour] = color[node] ^ 1;
                }else if(color[neighbour] == color[node]) {
                    return false;
                }
            }
        }
    }
    return true;
    }
}

*DFS : 
  class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        Arrays.fill(color, -1);

        for(int i = 0; i < n; i++) {
            if(color[i] == -1 && (dfs(i, color, graph, 0) == false)) return false;
        }

        return true;
    }

    public boolean dfs(int node, int[] color, int[][] graph, int clr) {
        
        color[node] = clr;
        for(int i = 0; i < graph[node].length; i++) {
            int neighbour = graph[node][i];
            if(color[neighbour] == -1) {
                if(dfs(neighbour, color, graph, clr ^ 1) == false) return false;
            }else if(color[neighbour] == clr) return false; 
        }

        return true;
    }
}
