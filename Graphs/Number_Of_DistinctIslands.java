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
