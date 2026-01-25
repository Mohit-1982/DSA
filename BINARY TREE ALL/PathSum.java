Leetcode - 112
  class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        boolean ans = pathSum(root,targetSum);
        return ans;
    }
    public boolean pathSum(TreeNode root,int targetSum) {
        if(root == null) return false;
        if(root.left == null && root.right == null) {
            if(targetSum == root.val) return true;
            else return false;
        }

        boolean left = pathSum(root.left,targetSum - root.val);
        boolean right = pathSum(root.right,targetSum - root.val);

        return left || right;
    }
}
