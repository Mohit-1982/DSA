Leetcode - 119
  Brute :  
    class Solution {
    static List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        int[][] arr = new int[rowIndex + 1][rowIndex + 1];
        for(int row = 0; row <= rowIndex; row++) {
            for(int col = 0; col <= row; col++) {
                if(col == 0 || col == row) arr[row][col] = 1;
                else {
                    int top = arr[row - 1][col];
                    int topLeft = arr[row - 1][col - 1];
                    arr[row][col] = top + topLeft;
                }
            }
        }
        for(int i = 0; i <= rowIndex; i++) {
            res.add(arr[rowIndex][i]);
        }
        return res;
    }
}

Optimal : 
  
