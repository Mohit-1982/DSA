Leetcode - 200
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
    public int numIslands(char[][] grid) {
        int count = 0;
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        Queue<Pair> q = new LinkedList<>();

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == '0' || visited[i][j]) continue;
                q.add(new Pair(i, j));
                visited[i][j] = true;
                while(!q.isEmpty()) {
                    Pair front = q.remove();
                    int row = front.row;
                    int col = front.col;
                    if(col + 1 < m && grid[row][col + 1] == '1' && !visited[row][col + 1]) {
                        q.add(new Pair(row, col + 1));
                        visited[row][col + 1] = true;
                    }
                    if(col - 1 >= 0 && grid[row][col - 1] == '1' && !visited[row][col - 1]) {
                        q.add(new Pair(row, col - 1));
                        visited[row][col - 1] = true;
                    }
                    if(row + 1 < n && grid[row + 1][col] == '1' && !visited[row + 1][col]) {
                        q.add(new Pair(row + 1, col));
                        visited[row + 1][col] = true;
                    }
                    if(row - 1 >= 0 && grid[row - 1][col] == '1' && !visited[row - 1][col]) {
                        q.add(new Pair(row - 1, col));
                        visited[row - 1][col] = true;
                    }
                }
                count++;
            }
        }
        return count;
    }
}
*DFS : 
  class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(vis[i][j] || grid[i][j] == '0') continue;
                dfs(grid, vis, i, j);
                count++;
            }
        }
        return count;
    }
    public void dfs(char[][] grid, boolean[][] vis, int row, int col) {
        if(row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || vis[row][col] || grid[row][col] == '0') return;

        vis[row][col] = true;
        dfs(grid, vis, row + 1, col);
        dfs(grid, vis, row - 1, col);
        dfs(grid, vis, row, col + 1);
        dfs(grid, vis, row, col - 1);
    }
}
*Space Optimal DFS : 
  class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        int n = grid.length;
        int m = grid[0].length;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == '2' || grid[i][j] == '0') continue;
                dfs(grid, i, j);
                count++;
            }
        }
        return count;
    }
    public void dfs(char[][] grid, int row, int col) {
        if(row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] == '2' || grid[row][col] == '0') return;

        grid[row][col] = '2';
        dfs(grid, row + 1, col);
        dfs(grid, row - 1, col);
        dfs(grid, row, col + 1);
        dfs(grid, row, col - 1);
    }
}
