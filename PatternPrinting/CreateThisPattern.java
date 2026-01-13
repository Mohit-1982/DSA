you are given an input n 
  n = 463
  print -->
  
      * * *
      * * *
      * * *
      * *
        *
        *
  
package Pattern;

public class PatternPriniting {
    public static void main(String[] args) {
        int n = 4633283;
        String[][] ans =  print(n);
        for(String[] thing : ans) {
            for(String ele : thing) {
                System.out.print(ele);
            }
            System.out.println();
        }
    }

    static String[][] print(int n) {
        int digits = digitMax(n,0);
        int max = digitMax(n,1);

        String[][] arr = new String[max][digits];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = " ";
            }
        }
        int col = arr[0].length - 1;
        while(col >= 0) {
            int rem = n % 10;
            for (int i = 0; i < rem; i++) {
                arr[i][col] = "*";
            }
            n /= 10;
            col--;
        }
        return arr;
    }

    static int digitMax(int n,int flag) {
        int digits = 0;
        int max = -1;
        while(n > 0) {
            int rem = n % 10;
            digits++;
            max = Math.max(max,rem);
            n /= 10;
        }
        if(flag == 0) return digits;
        else return max;
    }
}
