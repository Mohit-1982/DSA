Leetcode - 802
  Brute : 
    class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        List<Integer> res = new ArrayList<>();
        int[] vis = new int[n];
        int[] pathVis = new int[n];

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
