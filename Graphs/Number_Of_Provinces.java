Leetcode - 547
  Brute : 
    class Solution {
    public int findCircleNum(int[][] isConnected) {
        //solve this without creating the adj matrix 
        //solve with dfs and bfs
        int n = isConnected.length;
        ArrayList<ArrayList<Integer>> adj = adjForm(isConnected);
        HashSet<Integer> set = new HashSet<>();
        int count = 0;
        for(int i = 0; i < n; i++) {
            if(!set.contains(i)) {
                dfs(adj, set, i);
                count++;
            }
        }
        return count;
    }
    public void dfs(ArrayList<ArrayList<Integer>> adj, HashSet<Integer> set, int node) {
        set.add(node);
        for(int num : adj.get(node)) {
            if(!set.contains(num)) dfs(adj, set, num);
        }
    }
    public ArrayList<ArrayList<Integer>> adjForm(int[][] arr) {
        int n = arr.length;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for(int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(i != j && arr[i][j] == 1) adj.get(i).add(j);
            }
        }
        return adj;
    }
}
Optimal : 
  *DFS :   
    class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        HashSet<Integer> set = new HashSet<>();
        int count = 0;
        for(int i = 0; i < n; i++) {
            if(!set.contains(i)) {
                dfs(isConnected, set, i);
                count++;
            }
        }
        return count;
    }
    public void dfs(int[][] arr, HashSet<Integer> set, int node) {
        set.add(node);
        for(int i = 0; i < arr[node].length; i++) {
            if(arr[node][i] == 1 && !set.contains(i)) dfs(arr, set, i); //arr[node][i] == 1 this is telling the connection exists or not and i is the neigbhouring node
        }
    }
}
*BFS :
  class Solution {
    public int findCircleNum(int[][] arr) {
        int n = arr.length;
        HashSet<Integer> set = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        int count = 0;

        for(int i = 0; i < n; i++) {
            if(set.contains(i)) continue;
            q.add(i);
            set.add(i);
            while(!q.isEmpty()) {
                int front = q.remove();
                for(int j = 0; j < arr[front].length; j++) {
                    if(arr[front][j] == 1 && !set.contains(j)) {
                        set.add(j);
                        q.add(j);
                    }
                }
            }
            count++; //We are counting the number of connected components
          //Each BFS marks one province, so the number of BFS calls equals the number of connected components
        }
        return count;
    }
}
