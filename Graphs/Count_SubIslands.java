Leetcode - 1905
  class Solution {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int island = 0;
        int n = grid1.length;
        int m = grid1[0].length;
        boolean[] containsIsl = new boolean[1];
        boolean[][] vis = new boolean[n][m];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(!vis[i][j] && grid2[i][j] == 1) {
                    containsIsl[0] = true;
                    dfs(grid1, grid2, vis, containsIsl, i, j);
                    if(containsIsl[0]) island++;
                }
            }
        }

        return island;
    }

    public void dfs(int[][] grid1, int[][] grid2, boolean[][] vis, boolean[] conIsl, int row, int col) {
        if(row < 0 || col < 0 || row >= grid1.length || col >= grid1[0].length || vis[row][col] || grid2[row][col] == 0) return;
        vis[row][col] = true;
        if(grid1[row][col] == 0) conIsl[0] = false;

        int[] dr = {1, -1, 0, 0};
        int[] dc = {0, 0, 1, -1};

        for(int i = 0; i < 4; i++) {
            int nRow = row + dr[i];
            int nCol = col + dc[i];

            if(nRow >= 0 && nCol >= 0 && nRow < grid1.length && nCol < grid1[0].length && !vis[nRow][nCol] && grid2[nRow][nCol] != 0) {
                dfs(grid1, grid2, vis, conIsl, nRow, nCol);
            }
        }
    }
}
