Leetcode - 832
  Brute : 
    class Solution {
    public int[][] flipAndInvertImage(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;
        //Reverse
        for(int i = 0; i < n; i++) {
            int s = 0;
            int e = arr[i].length - 1;
            while(s < e) {
                int temp = arr[i][s];
                arr[i][s] = arr[i][e];
                arr[i][e] = temp;
                s++;
                e--;
            }
        }
        //Flip
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(arr[i][j] == 1) arr[i][j] = 0;
                else arr[i][j] = 1;
            }
        }
        return arr;
    }
}

Optimal : 
  class Solution {
    public int[][] flipAndInvertImage(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;
        for(int i = 0; i < n; i++) {
            int s = 0;
            int e = arr[i].length - 1;
            while(s <= e) {
                int temp = ((arr[i][s] == 1) ? 0 : 1);
                arr[i][s] = ((arr[i][e] == 1) ? 0 : 1);
                arr[i][e] = temp;
                s++;
                e--;
            }
        }
        return arr;
    }
}

More Cleaner : using xor
  class Solution {
    public int[][] flipAndInvertImage(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;
        for(int i = 0; i < n; i++) {
            int s = 0;
            int e = arr[i].length - 1;
            while(s <= e) {
                int temp = arr[i][s] ^ 1;
                arr[i][s] = arr[i][e] ^ 1;
                arr[i][e] = temp;
                s++;
                e--;
            }
        }
        return arr;
    }
}
    
