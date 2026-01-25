Leetcode - 94
  class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        inOrder(ans,root);
        return ans;
    }
    public void inOrder(List<Integer> ans,TreeNode root) {
        if(root == null) return;
        inOrder(ans,root.left);
        ans.add(root.val);
        inOrder(ans,root.right);
    }
}
