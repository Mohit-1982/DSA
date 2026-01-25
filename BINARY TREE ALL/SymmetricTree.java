Leetcode - 101
  class Solution {
    public boolean isSymmetric(TreeNode root) {
        return mirrorIdentical(root.left,root.right);
    }
    public boolean mirrorIdentical(TreeNode p,TreeNode q) {
        if(p == null && q == null) return true;
        
        if(p == null || q == null) return false;
        if(p.val != q.val) return false;

        boolean left = mirrorIdentical(p.left,q.right);
        boolean right = mirrorIdentical(p.right,q.left);

        return left && right;
    }
}
