Neetcode
  Brute : 
    class Triplet{
    int row;
    int col;
    int dist;

    Triplet(int row, int col, int dist) {
        this.row = row;
        this.col = col;
        this.dist = dist;
    }
}
class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        Queue<Triplet> q = new LinkedList<>();

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == 0) {
                    q.add(new Triplet(i, j, 0));
                    vis[i][j] = true;
                }
            }
        }
        
        int[] dr = {1, -1, 0, 0};
        int[] dc = {0, 0, 1, -1};

        while(!q.isEmpty()) {
            Triplet front = q.remove();
            int row = front.row;
            int col = front.col;
            int dist = front.dist;

            grid[row][col] = dist;

            for(int i = 0; i < 4; i++) {
                int newRow = row + dr[i];
                int newCol = col + dc[i];

                if(newRow >= 0 && newCol >= 0 && newRow < n && newCol < m && !vis[newRow][newCol] && grid[newRow][newCol] == Integer.MAX_VALUE) {
                    q.add(new Triplet(newRow, newCol, dist + 1));
                    vis[newRow][newCol] = true;
                }
            }
        }
    }
}
Optimal : Removed Visited Array
     class Triplet{
    int row;
    int col;
    int dist;

    Triplet(int row, int col, int dist) {
        this.row = row;
        this.col = col;
        this.dist = dist;
    }
}
class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<Triplet> q = new LinkedList<>();

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == 0) {
                    q.add(new Triplet(i, j, 0));
                }
            }
        }
        
        int[] dr = {1, -1, 0, 0};
        int[] dc = {0, 0, 1, -1};

        while(!q.isEmpty()) {
            Triplet front = q.remove();
            int row = front.row;
            int col = front.col;
            int dist = front.dist;

            for(int i = 0; i < 4; i++) {
                int newRow = row + dr[i];
                int newCol = col + dc[i];

                if(newRow >= 0 && newCol >= 0 && newRow < n && newCol < m && grid[newRow][newCol] == Integer.MAX_VALUE) {
                    q.add(new Triplet(newRow, newCol, dist + 1));
                    grid[newRow][newCol] = dist + 1;
                }
            }
        }
    }
}
  
