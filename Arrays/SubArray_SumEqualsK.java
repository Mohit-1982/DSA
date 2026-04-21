Leetcode - 560
  Brute : O(n^3)
    class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        List<List<Integer>> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                List<Integer> sub = new ArrayList<>();
                for (int l = i; l <= j; l++) {
                    sub.add(nums[l]);
                }
                list.add(sub);
            }
        }

        int count = 0;
        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < list.size(); i++) {
            int sum = 0;
            for (int ele : list.get(i)) {
                sum += ele;
            }
            if (sum == k) count++;
        }

        return count;
    }
}

  Better : O(n^2)
    class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];
                if (sum == k) count++;
            }
        }

        return count;
    }
}

Optimal : O(n)
  
    
