Leetcode - 236
  Brute : 
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return root;
        if(root == p || root == q) return root;
        boolean pLiesInLeft = exist(root.left,p);
        boolean qLiesInRight = exist(root.right,q);
        if(pLiesInLeft && !qLiesInRight) {
            //Both lies in left so, search in left
            return lowestCommonAncestor(root.left,p,q);
        }else if(!pLiesInLeft && qLiesInRight) {
            //Both lies in right so, search in right
            return lowestCommonAncestor(root.right,p,q);
        }else {
            return root;
        }
    }
    public boolean exist(TreeNode root,TreeNode p) {
        if(root == null) return false;
        if(root == p) return true;
        boolean left = exist(root.left,p);
        boolean right = exist(root.right,p);

        return left || right;
    }
}

Optimal : 
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        if(root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        if(left != null && right != null) return root;
        return (left == null) ? right : left;
    }
}
