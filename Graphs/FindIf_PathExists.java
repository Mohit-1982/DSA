Leetcode - 1971
  class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if (source == destination) return true;
        boolean[] vis = new boolean[n];
        List<List<Integer>> adj = adjBuild(n, edges);

        return dfs(adj, source, destination, vis);
    }

    public boolean dfs(List<List<Integer>> adj, int node, int dest, boolean[] vis) {
        if (node == dest) return true;
        vis[node] = true;

        for (int adjNode : adj.get(node)) {
            if (!vis[adjNode]) {
                if (dfs(adj, adjNode, dest, vis)) {
                    return true;
                }
            }
        }

        return false;
    }

    public List<List<Integer>> adjBuild(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        return adj;
    }
}
