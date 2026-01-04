Leetcode - 543

  class Solution {
    static int max;
    public int diameterOfBinaryTree(TreeNode root) {
        max = 0;
        helper(root);
        return max;
    }
    static int helper(TreeNode root) {
        if(root == null) return 0;
        int left = helper(root.left);
        int right = helper(root.right);
        max = Math.max(max,left+right);
        return 1 + Math.max(left,right);
    }
}
