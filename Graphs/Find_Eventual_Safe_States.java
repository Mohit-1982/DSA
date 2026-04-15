Leetcode - 802
  Brute : 
    class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        List<Integer> res = new ArrayList<>();
        int[] vis = new int[n];
        int[] pathVis = new int[n];
        // 0 = unknown
        // 1 = safe
        // -1 = unsafe

        for(int i = 0; i < n; i++) {
            if(vis[i] == 0) dfs(graph, res, vis, pathVis, i);
        }
        
        Collections.sort(res);
        return res;
    }

    public boolean dfs(int[][] graph, List<Integer> res, int[] vis, int[] pathVis, int node) {

        vis[node] = 1;
        pathVis[node] = 1;

        for(int ele : graph[node]) {
            if(vis[ele] == 0) {
                if(!dfs(graph, res, vis, pathVis, ele)) {
                    return false;//Every Neighbour don't led to a safe path
                }
            }else if(pathVis[ele] == 1) {
                return false;//Cycle Exist
            }
        }

        res.add(node);//safe node
        pathVis[node] = 0;//Backtrack from this path
        return true;//Safe path
    }
}
Optimal : 
  class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        int[] vis = new int[n];
        int[] safe = new int[n];
        // 0 = unknown
        // 1 = safe
        // -1 = unsafe
        int[] pathVis = new int[n];
        List<Integer> res = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            if(vis[i] == 0) dfs(graph, res, vis, pathVis, i, safe);
        }

        Collections.sort(res);
        return res;
    }

    public boolean dfs(int[][] graph, List<Integer> res, int[] vis, int[] pathVis, int node, int[] safe) {
        if(safe[node] == 1) return true;
        if(safe[node] == -1) return false;

        vis[node] = 1;
        pathVis[node] = 1;

        for(int ele : graph[node]) {
            if(vis[ele] == 0) {
                if(!dfs(graph, res, vis, pathVis, ele, safe)) {
                    return false;//Every Neighbour don't led to a safe path
                }
            }else {
                if(pathVis[ele] == 1) {
                    safe[node] = -1;
                    return false;//Cycle Exist
                }
                if(safe[ele] == -1) {
                    safe[node] = -1;
                    return false;//Path is Not Safe
                }
            }
        }

        safe[node] = 1;
        res.add(node);
        pathVis[node] = 0;
        return true;
    }
}

*DFS Clean Code + Dp Check
  class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        int[] dpCheck = new int[n];
        boolean[] vis = new boolean[n];
        boolean[] pathVis = new boolean[n];
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                dfs(i, vis, pathVis, res, graph, dpCheck);
            }
        }

        Collections.sort(res);
        return res;
    }

    public boolean dfs(int node, boolean[] vis, boolean[] pathVis, List<Integer> res, int[][] graph, int[] dpCheck) {

        vis[node] = true;
        pathVis[node] = true;

        for (int i = 0; i < graph[node].length; i++) {
            // i is not the neighbour graph[node][i] is.....
            int neigh = graph[node][i];

            if (!vis[neigh]) {
                if (!dfs(neigh, vis, pathVis, res, graph, dpCheck)) {
                    dpCheck[neigh] = -1;
                    return false;
                }
            }else if (pathVis[neigh]) {
                dpCheck[neigh] = -1;
                return false;
            }else if(dpCheck[node] == -1) {
                dpCheck[neigh] = -1;
                return false;
            }
        }

        pathVis[node] = false;
        res.add(node);
        return true;
    }
}

*BFS Kahn's Algorithm
  class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {//Reverse the graph
            for (int j = 0; j < graph[i].length; j++) {
                int u = graph[i][j];

                adj.get(u).add(i);
            }
        }

        int[] indeg = new int[n];

        for (int i = 0; i < adj.size(); i++) {
            for (int j = 0; j < adj.get(i).size(); j++) {
                indeg[adj.get(i).get(j)]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < indeg.length; i++) {
            if (indeg[i] == 0) {
                q.add(i);
            }
        }

        List<Integer> list = new ArrayList<>();

        while(!q.isEmpty()) {
            int node = q.remove();
            list.add(node);

            for (int adjNode : adj.get(node)) {
                indeg[adjNode]--;

                if (indeg[adjNode] == 0) {
                    q.add(adjNode);
                }
            }
        }

        Collections.sort(list);
        return list;
    }
}


