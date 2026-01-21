package Recursion;

import java.util.ArrayList;

public class PrintMazePath {
    public static void main(String[] args) {
        System.out.println(mazePaths(1,1,3,4));
    }
    static ArrayList<String> mazePaths(int m,int n,int row,int col) {
        if(m == row && n == col) {
            ArrayList<String> list = new ArrayList<>();
            list.add("");
            return list;
        }
        ArrayList<String> right = new ArrayList<>();
        ArrayList<String> down = new ArrayList<>();

        if(m < row) {
            down = mazePaths(m+1,n,row,col);
        }
        if(n < col) {
            right = mazePaths(m,n+1,row,col);
        }

        ArrayList<String> paths = new ArrayList<>();

        for(String ele : right) {
            paths.add("R" + ele);
        }
        for(String ele : down) {
            paths.add("D" + ele);
        }
        return paths;
    }
}
