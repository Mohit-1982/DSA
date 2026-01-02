Leetcode - 226

We change the left reference to point to what was on the right
Because of that, the left reference no longer points to the old left
But before breaking that connection, we saved the old left in temp
Then we attach that saved left to the right side using right = temp

  
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
