class Solution {
    public TreeNode deleteNode(TreeNode root, int target) {
        if(root == null) return null;
        if(root.val == target) return null;
        else if(root.val > target) {
            root.left = deleteNode(root.left,target);
        }
        else {
            root.right = deleteNode(root.right,target);
        }
        return root;
    }
}
