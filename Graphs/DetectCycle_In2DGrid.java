Leetcode - 1559
  DFS : 
    class Solution {
    public boolean containsCycle(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(!vis[i][j]) {
                    char ch = grid[i][j];
                    if(dfs(grid, vis, i, j, -1, -1, ch)) return true;
                }
            }
        }

        return false;
    }

    public boolean dfs(char[][] grid, boolean[][] vis, int row, int col, int pRow, int pCol, char ch) {
        
        vis[row][col] = true;
        int[] dr = {1, -1, 0, 0};
        int[] dc = {0, 0, 1, -1};

        for(int i = 0; i < 4; i++) {
            int newRow = row + dr[i];
            int newCol = col + dc[i];

            if(newRow >=0 && newCol >= 0 && newRow < grid.length && newCol < grid[0].length && ch == grid[newRow][newCol]) {
                if(!vis[newRow][newCol]) {
                    if(dfs(grid, vis, newRow, newCol, row, col, ch)) return true;
                }else if(newRow != pRow && newCol != pCol) {
                    //this newRow and newCol is already visited and not the current node parent means cycle
                    return true;
                }
            }
        }

        return false;
    }
}

BFS :
class Quad{
    int row;
    int col;
    int pRow;
    int pCol;

    Quad(int row, int col, int pRow, int pCol) {
        this.row = row;
        this.col = col;
        this.pRow = pRow;
        this.pCol = pCol;
    }
}
class Solution {
    public boolean containsCycle(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[] dr = {1, -1, 0, 0};
        int[] dc = {0, 0, 1, -1};
        Queue<Quad> q = new LinkedList<>();
        boolean[][] vis = new boolean[n][m];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(!vis[i][j]) {
                    vis[i][j] = true;
                    char ch = grid[i][j];
                    q.add(new Quad(i, j, -1, -1));
                    
                    while(!q.isEmpty()) {
                        Quad front = q.remove();
                        int row = front.row;
                        int col = front.col;
                        int pRow = front.pRow;
                        int pCol = front.pCol;

                        for(int k = 0; k < 4; k++) {
                            int newRow = row + dr[k];
                            int newCol = col + dc[k];
                            if(newRow >= 0 && newCol >= 0 && newRow < n && newCol < m && grid[newRow][newCol] == ch) {
                            
                            if(!vis[newRow][newCol]) {
                                q.add(new Quad(newRow, newCol, row, col));
                                vis[newRow][newCol] = true;
                            }
                            else if(newRow != pRow || newCol != pCol) return true;
                            }
                        }
                    }
                }
            }
        }

        return false;
    }
}
