public class KnightTour {
    public static void main(String[] args) {
        int[][] arr = {
                {0,0,0,0,0},
                {0,0,0,0,0},
                {0,0,0,0,0},
                {0,0,0,0,0},
                {0,0,0,0,0},
        };
        nightTour(arr,0,0,1);
    }
    static void nightTour(int[][] chess,int r,int c,int move) {
        if(r < 0 || c < 0 || r >= chess.length || c >= chess.length || chess[r][c] > 0) {
            return;
        }else if(move == (chess.length * chess.length)) { //found our answer
            chess[r][c] = move;
            for(int[] ele : chess) {
                for(int thing : ele) {
                    System.out.print(thing + " ");
                }
                System.out.println();
            }
            System.out.println();
            chess[r][c] = 0;
            return;
        }

        chess[r][c] = move;

        nightTour(chess,r - 2,c + 1,move + 1);
        nightTour(chess,r - 1,c + 2,move + 1);
        nightTour(chess,r + 1,c + 2,move + 1);
        nightTour(chess,r + 2,c + 1,move + 1);
        nightTour(chess,r + 2,c - 1,move + 1);
        nightTour(chess,r + 1,c - 2,move + 1);
        nightTour(chess,r - 1,c - 2,move + 1);
        nightTour(chess,r - 2,c - 1,move + 1);

        chess[r][c] = 0;
    }
}
