Leetcode - 1765
  class Pair{
    int row;
    int col;
    int dist;

    Pair(int row, int col, int dist) {
        this.row = row;
        this.col = col;
        this.dist = dist;
    }
}
class Solution {
    public int[][] highestPeak(int[][] isWater) {
        int n = isWater.length;
        int m = isWater[0].length;
        boolean[][] vis = new boolean[n][m];
        Queue<Pair> q = new LinkedList<>();

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(isWater[i][j] == 1) {
                    isWater[i][j] = 0;
                    vis[i][j] = true;
                    q.add(new Pair(i, j, 1));
                }
            }
        }

        int[] dr = {1, -1, 0, 0};
        int[] dc = {0, 0, 1, -1};

        while(!q.isEmpty()) {
            Pair front = q.remove();
            int row = front.row;
            int col = front.col;
            int dist = front.dist;

            for(int i = 0; i < 4; i++) {
                int nRow = row + dr[i];
                int nCol = col + dc[i];

                if(nRow >= 0 && nCol >= 0 && nRow < n && nCol < m && !vis[nRow][nCol]) {
                    vis[nRow][nCol] = true;
                    isWater[nRow][nCol] = dist;
                    q.add(new Pair(nRow, nCol, dist + 1));
                }
            }
        }

        return isWater;
    }
}
