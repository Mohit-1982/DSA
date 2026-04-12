Leetcode - 463
  Brute : 
    class Solution {
    public int islandPerimeter(int[][] grid) {
        int perimeter = 0;
        int n = grid.length;
        int m = grid[0].length;
        int[] dr = {1, -1, 0, 0};
        int[] dc = {0, 0, 1, -1};

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == 1) {
                    perimeter += 4;
                    for(int k = 0; k < 4; k++) {
                        int nRow = i + dr[k];
                        int nCol = j + dc[k];

                        if(nRow >= 0 && nCol >= 0 && nRow < n && nCol < m && grid[nRow][nCol] == 1) {
                            perimeter -= 1;
                        }
                    }
                }
            }
        }

        return perimeter;
    }
}

Optimal : 
  class Solution {
    public int islandPerimeter(int[][] grid) {
        int perimeter = 0;
        int n = grid.length;
        int m = grid[0].length;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == 1) {
                    perimeter += 4;
                    //we need to check only right and down this will process all 
                    //4 directions because this will precompute the minus for 
                    //later exploration top and left for that cell
                    if(j + 1 < m && grid[i][j + 1] == 1) perimeter -= 2;
                    if(i + 1 < n && grid[i + 1][j] == 1) perimeter -= 2;
                }
            }
        }

        return perimeter;
    }
}
