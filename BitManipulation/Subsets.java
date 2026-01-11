Leetcode - 78
Tc -- n * 2^n   Sc -- Auxilary -- n and total n * 2^n
  class Solution {
    public List<List<Integer>> subsets(int[] arr) {
        int m = arr.length;
        int n = 1 << m; //2 raise to power n
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0;i < n;i++) {
            List<Integer> list = new ArrayList<>();
            int k = i;
            for(int j = 0;j < m;j++) {
                if((k & 1) == 1) list.add(arr[j]);
                k = k >> 1;
            }
            ans.add(list);
        }
        return ans;
    }
}
