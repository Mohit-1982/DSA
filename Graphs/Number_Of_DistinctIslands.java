GFG
  *DFS :
  class Solution {
    int countDistinctIslands(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        HashSet<List<List<Integer>>> set = new HashSet<>();
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(!vis[i][j] && grid[i][j] == 1) {
                    List<List<Integer>> list = new ArrayList<>();
                    dfs(i, j, grid, vis, list, i, j);
                    set.add(list);
                }
            }
        }
        return set.size();
        
    }
    public void dfs(int row, int col, int[][] grid, boolean[][] vis, List<List<Integer>> list, int row0, int col0) {
        int n = grid.length;
        int m = grid[0].length;
        if(row < 0 || col < 0 || row >= n || col >= m || vis[row][col] || grid[row][col] == 0) return;
        
        vis[row][col] = true;
        list.add(Arrays.asList(row - row0, col - col0));
        dfs(row, col + 1, grid, vis, list, row0, col0);
        dfs(row + 1, col, grid, vis, list, row0, col0);
        dfs(row, col - 1, grid, vis, list, row0, col0);
        dfs(row - 1, col, grid, vis, list, row0, col0);
    }
}


*BFS : Better to use DFS for ordering

 class Pair {
    int row;
    int col;
    
    Pair(int row, int col) {
        this.row = row;
        this.col = col;
    }
}
class Solution {
    int countDistinctIslands(int[][] grid) {
        //Shape Tracking Approach
        int n = grid.length;
        int m = grid[0].length;
        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};
        Queue<Pair> q = new LinkedList<>();
        boolean[][] vis = new boolean[n][m];
        HashSet<ArrayList<ArrayList<Integer>>> set = new HashSet<>();
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!vis[i][j] && grid[i][j] == 1) {
                    int baseRow = i;
                    int baseCol = j;
                    vis[i][j] = true;
                    q.add(new Pair(i, j));
                    ArrayList<ArrayList<Integer>> list = new ArrayList<>();
                    ArrayList<Integer> base = new ArrayList<>();
                    base.add(0);
                    base.add(0);
                    list.add(base);
                    
                    while (!q.isEmpty()) {
                        Pair front = q.remove();
                        int row = front.row;
                        int col = front.col;
                        
                        for (int k = 0; k < 4; k++) {
                            int newRow = row + dr[k];
                            int newCol = col + dc[k];
                            
                            if (newRow >= 0 && newCol >= 0 && newRow < n && newCol < m && !vis[newRow][newCol] && grid[newRow][newCol] == 1) {
                                vis[newRow][newCol] = true;
                                ArrayList<Integer> list1 = new ArrayList<>();
                                q.add(new Pair(newRow, newCol));
                                list1.add(newRow - baseRow);
                                list1.add(newCol - baseCol);
                                list.add(list1);
                            }
                        }
                    }
                    
                    set.add(list);
                }
            }
        }
        
        return set.size();
    }
}
