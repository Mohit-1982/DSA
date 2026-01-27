Leetcode - 199
  class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null) return new ArrayList<>();

        List<Integer> ans = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);

        while(!q.isEmpty()) {
            int currLvl = q.size();
            for(int i = 0;i < currLvl;i++) {
                TreeNode front = q.remove();
                if(front.left != null) q.add(front.left);
                if(front.right != null) q.add(front.right);
                if(i == currLvl - 1) ans.add(front.val);
            }
        }
        return ans;
    }
}
