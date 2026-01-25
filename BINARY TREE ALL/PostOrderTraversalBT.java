Leetcode - 145
  class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        postOrder(ans,root);
        return ans;
    }
    public void postOrder(List<Integer> ans,TreeNode root) {
        if(root == null) return;
        postOrder(ans,root.left);
        postOrder(ans,root.right);
        ans.add(root.val);
    }
}
