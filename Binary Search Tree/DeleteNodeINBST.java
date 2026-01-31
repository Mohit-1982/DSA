Leetcode - 450
  class Solution {
    public TreeNode deleteNode(TreeNode root, int target) {
        if(root == null) return null;
        if(root.val > target) {
            root.left = deleteNode(root.left,target);
        }else if(root.val < target) {
            root.right = deleteNode(root.right,target);
        }else {
            if(root.left == null && root.right == null) {
                //Leaf Node Condition
                return null;
            }
            //Single Node Case
            if(root.left == null) {
                return root.right;
            }
            if(root.right == null) {
                return root.left;
            }
            //Two Nodes Case
            TreeNode p = root.left;
            while(p.right != null) {
                p = p.right;
            }
            root.left = deleteNode(root.left,p.val);
            p.left = root.left;
            p.right = root.right;
            return p;
        }
        return root;
    }
}
