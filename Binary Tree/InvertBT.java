Leetcode - 226

  class Solution {
    public TreeNode invertTree(TreeNode root) {
        helper(root);
        return root;
    }
    static void helper(TreeNode root) {
        if(root == null) return;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        helper(root.left);
        helper(root.right);
    }
}
