Leetcode - 104

  class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        int ans = helper(root);
        return ans;
    }
    public int helper(TreeNode root) {
        if(root == null) return 0;
        int left = helper(root.left);
        int right = helper(root.right);
        return 1 + Math.max(left,right);
    }
}
