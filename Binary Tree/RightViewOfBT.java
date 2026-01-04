Leetcode - 199

  class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        view(ans,0,root);
        return ans;
    }
    public void view(List<Integer> ans,int lev,TreeNode root) {
        if(root== null) return;
        if(lev >= ans.size()) ans.add(root.val);
        else ans.set(lev,root.val);
        view(ans,lev+1,root.left);
        view(ans,lev+1,root.right);
    }
}
