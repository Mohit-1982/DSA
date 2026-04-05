Leetcode - 695
 *DFS : 
    class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        int n = grid.length;
        int m = grid[0].length;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == 1) {
                    int call = dfs(grid, i, j);
                    maxArea = Math.max(maxArea, call);
                }
            }
        }

        return maxArea;
    }

    public int dfs(int[][] grid, int row, int col) {
        if(row >= grid.length || col >= grid[0].length || col < 0 || row < 0 || grid[row][col] != 1) return 0;

        grid[row][col] = 2;
        return 1 + dfs(grid, row + 1, col) + dfs(grid, row - 1, col) +dfs(grid, row, col + 1) + dfs(grid, row, col - 1);
    }
}

*BFS : 
  class Pair{
    int row;
    int col;

    Pair(int row, int col) {
        this.row = row;
        this.col = col;
    }
}
class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        int n = grid.length;
        int m = grid[0].length;
        int[] dr = {1, -1, 0, 0};
        int[] dc = {0, 0, 1, -1};
        Queue<Pair> q = new LinkedList<>();

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                int area = 0;
                if(grid[i][j] != 1) continue;

                q.add(new Pair(i, j));
                grid[i][j] = 2;

                while(!q.isEmpty()) {
                    area++;
                    Pair front = q.remove();
                    int row = front.row;
                    int col = front.col;

                    for(int k = 0; k < 4; k++) {
                        int newRow = row + dr[k];
                        int newCol = col + dc[k];

                        if(newRow < n && newCol < m && newRow >= 0 && newCol >= 0 && grid[newRow][newCol] == 1) {
                            q.add(new Pair(newRow, newCol));
                            grid[newRow][newCol] = 2;
                        }
                    }
                }
                maxArea = Math.max(maxArea, area);
            }
        }
        return maxArea;
    }
}
