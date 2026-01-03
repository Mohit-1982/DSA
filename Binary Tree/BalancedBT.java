Leetcode - 110

class Solution {
    static boolean flag;
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        flag = true;
        helper(root);
        return flag;
    }
    public int helper(TreeNode root) {
        if(root == null) return 0;
        int leftSize = helper(root.left);
        int rightSize = helper(root.right);
        if(Math.abs(leftSize - rightSize) > 1) flag = false;
        return 1 + Math.max(leftSize,rightSize);
    }
}
