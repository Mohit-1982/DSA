import java.util.ArrayList;

public class GetPaths {
    public static void main(String[] args) {
        System.out.println(stairsPath(3));
    }
    static ArrayList<String> stairsPath(int n) {
        //base case
        //1.If n == 0 valid path
        if(n == 0) {
            ArrayList<String> list = new ArrayList<>();
            list.add(""); //return list with empty string because if we are at stair zero there is a path
            //exist which is don't move from you location.
            return list;
        }
        //2.if n is negative invalid path we don't have to consider it
        if(n < 0) {
            return new ArrayList<>(); //return empty arraylist
        }
        ArrayList<String> paths1 = stairsPath(n - 1);//calculate all paths for 1 steps
        ArrayList<String> paths2 = stairsPath(n - 2);//calculate all paths for 2 steps
        ArrayList<String> paths3 = stairsPath(n - 3);//calculate all paths for 3 steps

        ArrayList<String> paths = new ArrayList<>();
        //whatever answer we have for p1 we will add 1 on front of it
        for(String s : paths1) {
            paths.add(1 + s);
        }
        //whatever answer we have for p2 we will add 2 on front of it
        for(String s : paths2) {
            paths.add(2 + s);
        }
        //whatever answer we have for p3 we will add 3 on front of it
        for(String s : paths3) {
            paths.add(3 + s);
        }
        return paths;
    }
}
