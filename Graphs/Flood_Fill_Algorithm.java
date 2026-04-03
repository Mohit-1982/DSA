GFG
  *DFS : 
    class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image[sr][sc] == newColor);
        int n = image.length;
        int m = image[0].length;
        boolean[][] vis = new boolean[n][m];
        int orgClr = image[sr][sc];
        
        dfs(image, vis, sr, sc, newColor, orgClr);
        return image;
    }
    public void dfs(int[][] image, boolean[][] vis, int row, int col, int newClr, int orgClr) {
        if(row < 0 || col < 0 || row >= image.length || col >= image[0].length || vis[row][col] || image[row][col] != orgClr) return;
        
        image[row][col] = newClr;
        vis[row][col] = true;
        dfs(image, vis, row + 1, col, newClr, orgClr);
        dfs(image, vis, row - 1, col, newClr, orgClr);
        dfs(image, vis, row, col + 1, newClr, orgClr);
        dfs(image, vis, row, col - 1, newClr, orgClr);
    }
}
*Space Optimal DFS :
  class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image[sr][sc] == newColor) return image;
        int n = image.length;
        int m = image[0].length;
        int orgClr = image[sr][sc];
        
        dfs(image, sr, sc, newColor, orgClr);
        return image;
    }
    public void dfs(int[][] image, int row, int col, int newClr, int orgClr) {
        if(row < 0 || col < 0 || row >= image.length || col >= image[0].length || image[row][col] != orgClr) return;
        
        image[row][col] = newClr;
        dfs(image, row + 1, col, newClr, orgClr);
        dfs(image, row - 1, col, newClr, orgClr);
        dfs(image, row, col + 1, newClr, orgClr);
        dfs(image, row, col - 1, newClr, orgClr);
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
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int oriClr = image[sr][sc];
        if(oriClr == newColor) return image;
        Queue<Pair> q = new LinkedList<>();
        
        q.add(new Pair(sr, sc));
        image[sr][sc] = newColor;
        
        while(!q.isEmpty()) {
            Pair front = q.remove();
            int row = front.row;
            int col = front.col;
            
            //Traverse to All the Neighbours
            if(row + 1 < image.length && image[row + 1][col] == oriClr) {
                q.add(new Pair(row + 1, col));
                image[row + 1][col] = newColor;
            }
                
            if(row - 1 >= 0 && image[row - 1][col] == oriClr) {
                q.add(new Pair(row - 1, col));
                image[row - 1][col] = newColor;
            } 
                
            if(col + 1 < image[row].length && image[row][col + 1] == oriClr) {
                q.add(new Pair(row, col + 1));
                image[row][col + 1] = newColor;
            }
    
            if(col - 1 >= 0 && image[row][col - 1] == oriClr) {
                q.add(new Pair(row, col - 1));
                image[row][col - 1] = newColor;
            }
                
        }
        
        return image;
    }
}
