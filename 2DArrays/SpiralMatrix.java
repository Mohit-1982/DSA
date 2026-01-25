Leetcode - 54
  class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int fr = 0;
        int lr = matrix.length - 1;
        int fc = 0;
        int lc = matrix[0].length - 1;
        List<Integer> list = new ArrayList<>();
        while(fr <= lr && fc <= lc) {

            for(int i = fc;i <= lc;i++) {
                list.add(matrix[fr][i]);
            }
            fr++;

            for(int i = fr;i <= lr;i++) {
                list.add(matrix[i][lc]);
            }
            lc--;
            if(fr <= lr) { //Boundary condition check if Only one cell is remaining so both of these overite each other
                for(int i = lc;i >= fc;i--) {
                list.add(matrix[lr][i]);
            }
            lr--;
            }
            
            if(fc <= lc) { //Boundary condition check if Only one cell is remaining so both of these overite each other
                for(int i = lr;i >= fr;i--) {
                list.add(matrix[i][fc]);
            }
            fc++;
            }
        }
        return list;
    }
}
