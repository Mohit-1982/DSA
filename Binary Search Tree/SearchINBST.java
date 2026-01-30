Leetcode - 700
  class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        return search(root,val);
    }
    public TreeNode search(TreeNode root,int val) {
        if(root == null) return null;
        if(root.val > val) {
            return search(root.left,val);
        }else if(root.val < val) {
            return search(root.right,val);
        }else {
            return root;
        }
    }
}
