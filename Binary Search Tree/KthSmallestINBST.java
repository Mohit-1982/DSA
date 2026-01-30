Leetcode - 230
  class Solution {
    public int kthSmallest(TreeNode root, int k) {
        ArrayList<Integer> ans = new ArrayList<>();
        kth(root,k,ans);
        return ans.get(k - 1);
    }
    public void kth(TreeNode root,int k,ArrayList<Integer> ans) {
        if(root == null) return;
        kth(root.left,k,ans);
        ans.add(root.val);
        kth(root.right,k,ans);
    }
}
