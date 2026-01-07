Leetcode - 958

class Solution {
    static int Actualsize;
    public boolean isCompleteTree(TreeNode root) {
        int i = 1;
        Actualsize = helper(root);
        boolean Fakesize = helper2(root,i);
        return Fakesize;
    }
    public int helper(TreeNode root) {
        if(root == null) return 0;
        return 1 + helper(root.left) + helper(root.right);
    }
    public boolean helper2(TreeNode root,int i) {
        if(root == null) return true;
        if(i > Actualsize) return false;
        return helper2(root.left,2*i) && helper2(root.right,2*i + 1);
    }
}
