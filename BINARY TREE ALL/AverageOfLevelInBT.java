Leetcode - 637
  class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        if(root == null) return new ArrayList<>();
        List<Double> list = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        double avg = 0;
        q.add(root);
        while(!q.isEmpty()) {
            int currLvl = q.size();
            for(int i = 0;i < currLvl;i++) {
                TreeNode front = q.remove();
                if(front.left != null) q.add(front.left);
                if(front.right != null) q.add(front.right);
                avg += front.val;
            }
            list.add(avg/currLvl);
            avg = 0;
        }
        return list;
    }
}
