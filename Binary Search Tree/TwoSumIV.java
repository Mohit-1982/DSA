Leetcode - 653
class Solution {
    public boolean findTarget(TreeNode root, int k) {
        //Optimal
        HashSet<Integer> set = new HashSet<>();
        dfs(set, root);

        for (int ele : set) {
            int rem = k - ele;
            if (set.contains(rem) && ele != rem) {
                return true;
            } 
        }

        return false;
    }
    public void dfs(HashSet<Integer> set, TreeNode root) {
        if (root == null) return;
        set.add(root.val);
        dfs(set, root.left);
        dfs(set, root.right);
    }
}
