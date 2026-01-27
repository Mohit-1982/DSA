Leetcode - 199
  //Using BFS
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

//Using DFS
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        //using dfs
        if(root == null) return new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        dfs(root,ans,0);
        return ans;
    }
    public void dfs(TreeNode root,List<Integer> ans,int level) {
        if(root == null) return;
        if(level >= ans.size()) {
            ans.add(root.val);
        }else {
            ans.set(level,root.val);
        }
        dfs(root.left,ans,level + 1);
        dfs(root.right,ans,level + 1);
    }
}
