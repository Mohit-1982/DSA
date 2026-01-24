GFG

  class Solution {
    public ArrayList<String> ratInMaze(int[][] maze) {
        int n = maze.length;//row
        int m = maze[0].length;//col
        ArrayList<String> ans = ratMaze(maze,0,0,n,m);
        return ans;
    }
    public ArrayList<String> ratMaze(int[][] arr,int row,int col,int n,int m) {
        //Invalid Cases
        if(row < 0 || col < 0 || row >= arr.length || col >= arr[0].length || arr[row][col] == 0 || arr[row][col] == 2) {
            return new ArrayList<>();
        }
        
        //Base Case
        if(row == n - 1 && col == m - 1) {
            ArrayList<String> list = new ArrayList<>();
            list.add("");
            return list;
        }
        
        arr[row][col] = 2;//Make these cells visited
        
        ArrayList<String> down = ratMaze(arr,row + 1,col,n,m);
        ArrayList<String> left = ratMaze(arr,row,col - 1,n,m);
        ArrayList<String> right = ratMaze(arr,row,col + 1,n,m);
        ArrayList<String> top = ratMaze(arr,row - 1,col,n,m);
        
        arr[row][col] = 1;//BackTrack
        
        ArrayList<String> paths = new ArrayList<>(); //this will store the answers
        
        for(String ele : down) { //to generate in lexograpy order run with sequence
            paths.add("D" + ele);
        }
        for(String ele : left) {
            paths.add("L" + ele);
        }
        for(String ele : right) {
            paths.add("R" + ele);
        }
        for(String ele : top) {
            paths.add("U" + ele);
        }
        
        return paths;
    }
}
