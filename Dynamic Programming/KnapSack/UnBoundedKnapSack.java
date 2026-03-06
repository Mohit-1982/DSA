GFG
  Brute : 
    class Solution {
    public int knapSack(int val[], int wt[], int capacity) {
        //Ek item ko bohot baar le sakte h jabtak capacity bachi ho
        return maxProfit(val, wt, 0, capacity);
    }
    public int maxProfit(int[] val, int[] wt, int i, int capacity) {
        if(i >= val.length) {
            if(capacity >= 0) return 0;
            else return Integer.MIN_VALUE;
        }
        if(capacity < 0) return Integer.MIN_VALUE;
        int pick = val[i] + maxProfit(val, wt, i, capacity - wt[i]);
        int skip = maxProfit(val, wt, i + 1, capacity);
        int ans = Math.max(pick, skip);
        return ans;
    }
}

Optimal : 
  *Memoization : 
    class Solution {
    public int knapSack(int val[], int wt[], int capacity) {
        //Ek item ko bohot baar le sakte h jabtak capacity bachi ho
        int[][] dp = new int[val.length][capacity + 1];
        for(int i = 0; i < dp.length; i++) {
            for(int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }
        return maxProfit(val, wt, 0, capacity, dp);
    }
    public int maxProfit(int[] val, int[] wt, int i, int capacity, int[][] dp) {
        if(i >= val.length) {
            if(capacity >= 0) return 0;
            else return Integer.MIN_VALUE;
        }
        if(capacity < 0) return Integer.MIN_VALUE;
        if(dp[i][capacity] != -1) return dp[i][capacity];
        int pick = val[i] + maxProfit(val, wt, i, capacity - wt[i], dp);
        int skip = maxProfit(val, wt, i + 1, capacity, dp);
        int ans = Math.max(pick, skip);
        dp[i][capacity] = ans;
        return ans;
    }
}
