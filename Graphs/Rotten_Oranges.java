Leetcode - 994
  Brute : 
    class Triplet{
    int row;
    int col;
    int level;

    Triplet(int row, int col, int level) {
        this.row = row;
        this.col = col;
        this.level = level;
    }
}
class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int time = 0;
        int freshOrg = 0;

        Queue<Triplet> q = new LinkedList<>();
        int[] dr = {1, -1, 0, 0};
        int[] dc = {0, 0, 1, -1};

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == 1) freshOrg++;
                if(grid[i][j] == 2) {
                    q.add(new Triplet(i, j, 0));
                    grid[i][j] = 3;
                }
            }
        }

        while(!q.isEmpty()) {
                    Triplet front = q.remove();
                    int row = front.row;
                    int col = front.col;
                    int level = front.level;
        
                    for(int k = 0; k < 4; k++) {
                        int newRow = row + dr[k];
                        int newCol = col + dc[k];

                        if(newRow >= 0 && newCol >= 0 && newRow < n && newCol < m && grid[newRow][newCol] == 1) {
                            q.add(new Triplet(newRow, newCol, level + 1));
                            grid[newRow][newCol] = 3;
                            freshOrg--;
                        }
                    }
                    time = Math.max(time, level);
                }
        
        if(freshOrg > 0) return -1;
        return time;
    }
}
Optimal :   
  
