Leetcode - 113
  class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if(root == null) return new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> arr = new ArrayList<>();
        pathSum(root,ans,arr,targetSum);
        return ans;
    }
    public void pathSum(TreeNode root,List<List<Integer>> ans,List<Integer> arr,int sum) {
        if(root == null) return;
        if(root.left == null && root.right == null) {
            if(sum - root.val == 0) {
                arr.add(root.val);
                List<Integer> list = new ArrayList<>();
                list.addAll(arr);
                ans.add(list);
                arr.remove(arr.size() - 1);
            }
            return;
        }
        arr.add(root.val);
        pathSum(root.left,ans,arr,sum - root.val);
        pathSum(root.right,ans,arr,sum - root.val);
        arr.remove(arr.size() - 1);
    }
}
