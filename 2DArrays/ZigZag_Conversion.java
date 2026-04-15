Leetcode - 6
  class Solution {
    public String convert(String s, int numRows) {

        // OPTIMAL

        if (numRows == 1) return s;
        int i = 0;
        int row = 0;
        int col = 0;
        int n = s.length();
        Character[][] arr = new Character[numRows][n];
        StringBuilder sb = new StringBuilder();

        while (i < n) {

            while (i < n && row != arr.length) {
                char ch = s.charAt(i);
                arr[row][col] = ch;
                row++;
                i++;
            }
            
            col++;
            row -= 2;

            while (i < n && row != -1) {
                char ch = s.charAt(i);
                arr[row][col] = ch;
                row--;
                col++;
                i++;
            }

            row += 2;
            col--;
        }

        for (i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] != null) {
                    sb.append(arr[i][j]);
                }
            }
        }

        return sb.toString();
    }
}
