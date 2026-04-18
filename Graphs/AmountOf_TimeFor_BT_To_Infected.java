Leetcode - 2385
  class Pair {
    TreeNode currNode;
    int level;

    Pair(TreeNode currNode, int level) {
        this.currNode = currNode;
        this.level = level;
    }
}
class Solution {
    public int amountOfTime(TreeNode root, int start) {
        int maxTime = 0;
        Queue<Pair> q = new LinkedList<>();
        TreeNode[] startNode = new TreeNode[1];
        HashSet<TreeNode> vis = new HashSet<>();
        HashMap<TreeNode, TreeNode> parent = new HashMap<>();
        getParent(root, start, parent, startNode, null);

        vis.add(startNode[0]);
        q.add(new Pair(startNode[0], 0));

        while (!q.isEmpty()) {
            Pair front = q.remove();
            TreeNode node = front.currNode;
            int level = front.level;
            maxTime = Math.max(maxTime, level);

            //Parent 
            if (parent.get(node) != null && !vis.contains(parent.get(node))) {
                vis.add(parent.get(node));
                q.add(new Pair(parent.get(node), level + 1));
            }
            //Left Child
            if (node.left != null && !vis.contains(node.left)) {
                vis.add(node.left);
                q.add(new Pair(node.left, level + 1));
            }
            //Right Child
            if (node.right != null && !vis.contains(node.right)) {
                vis.add(node.right);
                q.add(new Pair(node.right, level + 1));
            }
        }

        return maxTime;
    }

    public void getParent(TreeNode root, int start, HashMap<TreeNode, TreeNode> parent, TreeNode[] startNode, TreeNode prev) {
        if (root == null) return;

        parent.put(root, prev);
        if (root.val == start) startNode[0] = root;
        getParent(root.left, start, parent, startNode, root);
        getParent(root.right, start, parent, startNode, root);
    }
}
