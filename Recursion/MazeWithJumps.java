import java.util.ArrayList;

public class MazePathWithJump2 {
    public static void main(String[] args) {
        System.out.println(mazePath(1,1,3,3));
    }
    static ArrayList<String> mazePath(int m,int n,int row,int col) {
        if(m == row && n == col) {
            ArrayList<String> list = new ArrayList<>();
            list.add("");
            return list;
        }

        ArrayList<String> paths = new ArrayList<>();
        //down
        for (int i = 1; i <= row - m; i++) {
            ArrayList<String> right = mazePath(m+i,n,row,col);
            for(String ele : right) {
                paths.add("D" + i + " " + ele);
            }
        }
        //dia
        for (int i = 1; (i <= row - m) && (i <= col - n); i++) {
            ArrayList<String> dia = mazePath(m+i,n+i,row,col);
            for(String ele : dia) {
                paths.add("C" + i + " " + ele);
            }
        }
        //right
        for (int i = 1; i <= col - n; i++) {
            ArrayList<String> down = mazePath(m,n+i,row,col);
            for(String ele : down) {
                paths.add("R" + i + " " + ele);
            }
        }
        return paths;
    }
}
