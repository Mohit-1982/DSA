Leetcode - 144
  class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        preTraversal(ans,root);
        return ans;
    }
    public void preTraversal(List<Integer> ans,TreeNode root) {
        if(root == null) return;
        ans.add(root.val);
        preTraversal(ans,root.left);
        preTraversal(ans,root.right);
    }
}
