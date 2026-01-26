Leetcode - 733
  class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        flood(image,sr,sc,color,image[sr][sc]);
        return image;
    }
    public void flood(int[][] image, int sr, int sc, int color,int val) {
        if(sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length || image[sr][sc] == color || image[sr][sc] != val) {
            //image[sr][sc] == color why adding this check ? 
            //because if we dont add this and all color are equal to starting pixel color 
            //we will travel over the matrix again and again and 
            //it will give stack overflow error.
            return;
        }
        image[sr][sc] = color;
        flood(image,sr - 1,sc,color,val);
        flood(image,sr + 1,sc,color,val);
        flood(image,sr,sc - 1,color,val);
        flood(image,sr,sc + 1,color,val);
    }
}
