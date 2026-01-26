Leetcode - 102
  class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) return new ArrayList<>();

        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);

        while(!q.isEmpty()) {
            int level = q.size();
            List<Integer> list = new ArrayList<>();
            for(int i = 0;i < level;i++) {
                TreeNode front = q.remove();
                if(front.left != null) q.add(front.left);
                if(front.right != null) q.add(front.right);
                list.add(front.val);
            }
            ans.add(list);
        }
        return ans;
    }
}
