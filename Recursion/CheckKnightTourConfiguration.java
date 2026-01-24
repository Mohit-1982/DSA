Leetcode : 2596
  //Their is a better solution than this
  class Solution {
    public boolean checkValidGrid(int[][] grid) {
       return knightTour(grid,0,0,0);
    }
    public boolean knightTour(int[][] grid,int row,int col,int move) {
        if(row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] != move) {
            return false;
        }
        if(move == (grid.length * grid[0].length) - 1) {
            if(grid[row][col] == move)
                return true;
            else 
                return false;
        } 

        boolean topRight = knightTour(grid,row - 2,col + 1,move + 1);
        boolean rightTop = knightTour(grid,row - 1,col + 2,move + 1);
        boolean rightDown = knightTour(grid,row + 1,col + 2,move + 1);
        boolean downRight = knightTour(grid,row + 2,col + 1,move + 1);
        boolean downLeft = knightTour(grid,row + 2,col - 1,move + 1);
        boolean leftDown = knightTour(grid,row + 1,col - 2,move + 1);
        boolean leftTop = knightTour(grid,row - 1,col - 2,move + 1);
        boolean topLeft = knightTour(grid,row - 2,col - 1,move + 1);

        return topRight || rightTop || rightDown || downRight || downLeft || leftDown || leftTop || topLeft;
    }
}
