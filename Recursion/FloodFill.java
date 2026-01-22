import java.util.ArrayList;

public class FloodFill {
    public static void main(String[] args) {
        int[][] maze = {
                {0,1,0,0,0,0,0},
                {0,1,0,1,1,1,0},
                {0,0,0,0,0,0,0},
                {1,0,1,1,0,1,1},
                {1,0,1,1,0,0,1},
                {1,0,0,0,0,0,0},
        };
        int row = 0;
        int col = 0;
        ArrayList<String> ans = floodFill(maze,row,col);
        System.out.println(ans);
    }
    static ArrayList<String> floodFill(int[][] arr,int row,int col) {

        if(row == arr.length - 1 && col == arr[0].length - 1) {
            ArrayList<String> list = new ArrayList<>();
            list.add("");
            return list;
        }

        if(row < 0 || col < 0 || row >= arr.length || col >= arr[0].length || arr[row][col] == 1) {
            return new ArrayList<>();
        }

        arr[row][col] = 1;

        ArrayList<String> top = floodFill(arr,row - 1,col);
        ArrayList<String> down = floodFill(arr,row + 1,col);
        ArrayList<String> right = floodFill(arr,row,col + 1);
        ArrayList<String> left = floodFill(arr,row,col - 1);

        arr[row][col] = 0;
        ArrayList<String> paths = new ArrayList<>();

        //top
            for(String ele : top) {
                paths.add("T" + ele);
            }
        //down
            for(String ele : down) {
                paths.add("D" + ele);
            }
        //left
            for(String ele : left) {
                paths.add("L" + ele);
            }
        //right
            for(String ele : right) {
                paths.add("R" + ele);
            }
        return paths;
    }
}
