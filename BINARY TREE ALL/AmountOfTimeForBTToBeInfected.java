Leetcode - 2385
  class Pair{
    TreeNode node;
    int level;
    Pair(TreeNode node,int level) {
        this.node = node;
        this.level = level;
    }
}
class Solution {
    public int amountOfTime(TreeNode root, int start) {
        HashMap<TreeNode,TreeNode> parent = new HashMap<>();
        HashSet<TreeNode> burned = new HashSet<>();
        TreeNode[] arr = new TreeNode[1];
        dfs(root,parent,arr,start);
        TreeNode firstBurned = arr[0];
        Queue<Pair> q = new LinkedList<>();
        int level = 0;
        q.add(new Pair(firstBurned,level));
        burned.add(firstBurned);
        int time = 0;
        while(!q.isEmpty()) {
            Pair front = q.remove();
            if(front.node.left != null && !(burned.contains(front.node.left))) q.add(new Pair(front.node.left,front.level + 1));
            if(front.node.right != null && !(burned.contains(front.node.right))) q.add(new Pair(front.node.right,front.level + 1));
            if(parent.containsKey(front.node) && !(burned.contains(parent.get(front.node)))) q.add(new Pair(parent.get(front.node),front.level + 1));
            time = Math.max(time,front.level);
            burned.add(front.node);
        }
        return time;
    }
    public void dfs(TreeNode root,HashMap<TreeNode,TreeNode> parent,TreeNode[] arr,int start) {
        if(root == null) return;
        if(root.val == start) arr[0] = root; 
        if(root.left != null) parent.put(root.left,root);
        if(root.right != null) parent.put(root.right,root);
        dfs(root.left,parent,arr,start);
        dfs(root.right,parent,arr,start);
    }
}
