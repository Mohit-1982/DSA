Leetcode - 861
  class Solution {
    public int matrixScore(int[][] arr) {
        for(int i = 0;i<arr.length;i++) {
            if(arr[i][0] == 0) {
                for(int j = 0;j<arr[0].length;j++) {
                    if(arr[i][j] == 0) arr[i][j] = 1;
                    else arr[i][j] = 0;
                    //we can use arr[i][j] ^= 1; 
                    //         OR
                    //arr[i][j] = 1 - arr[i][j]; these two are better than if else
                }
            }
        }
        int count0 = 0;
        int count1 = 0;
        for(int i = 0;i<arr[0].length;i++) {
            count0 = 0;
            count1 = 0;
            for(int j = 0;j<arr.length;j++) {
                if(arr[j][i] == 0) count0++;
                else count1++;
            }
            if(count0 > count1) {
                for(int j = 0;j<arr.length;j++) {
                    arr[j][i] ^= 1;
                }
            }
        }
        int sum = 0;
        int pow = 1;
        for(int i = arr[0].length-1;i>=0;i--) {
            int ones = 0;
            for(int j = 0;j<arr.length;j++) {
                if(arr[j][i] == 1) ones++;
            }
            sum += pow * ones;
            pow *= 2;
        }
        return sum;
    }
}
