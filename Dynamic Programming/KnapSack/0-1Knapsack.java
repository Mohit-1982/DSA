GFG
  Brute : 
      class Solution {
    public int knapsack(int capacity, int val[], int wt[]) {
        return helper(0, capacity, val, wt);
    }
    public int helper(int idx, int capacity, int[] val, int[] wt) {
        if(capacity == 0 || idx >= val.length) {
            return 0;
        }
        if(wt[idx] > capacity) {
            return helper(idx + 1, capacity, val, wt);
        }
        int pick = val[idx] + helper(idx + 1, capacity - wt[idx], val, wt);
        int skip = helper(idx + 1, capacity, val, wt);
        return Math.max(pick, skip);
    }
}
Brute : More Readable
      class Solution {
    public int knapsack(int capacity, int val[], int wt[]) {
        return helper(0, capacity, val, wt);
    }
    public int helper(int idx, int capacity, int[] val, int[] wt) {
        if(idx >= val.length) {
            if(capacity >= 0) return 0;
            else return Integer.MIN_VALUE;
        }
        int pick = val[idx] + helper(idx + 1, capacity - wt[idx], val, wt);
        int skip = helper(idx + 1, capacity, val, wt);
        return Math.max(pick, skip);
    }
}

Optimal : 
  *Memoization
    class Solution {
    public int knapsack(int capacity, int val[], int wt[]) {
        //idx is going from 0 to n - 1
        //Capacity is going from capacity to 0 here capacity is also included
        //we are not letting the capacity to go negative
        int[][] dp = new int[val.length][capacity + 1];
        for(int i = 0; i < dp.length; i++) {
            for(int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }
        return helper(0, capacity, val, wt, dp);
    }
    public int helper(int idx, int capacity, int[] val, int[] wt, int[][] dp) {
        if(idx >= val.length) {
            if(capacity >= 0) return 0;
            else return Integer.MIN_VALUE;
        }
        if(capacity < 0) return Integer.MIN_VALUE;
        if(dp[idx][capacity] != -1) return dp[idx][capacity];
        int pick = val[idx] + helper(idx + 1, capacity - wt[idx], val, wt, dp);
        int skip = helper(idx + 1, capacity, val, wt, dp);
        int ans = Math.max(pick, skip);
        dp[idx][capacity] = ans;
        return ans;
    }
}
