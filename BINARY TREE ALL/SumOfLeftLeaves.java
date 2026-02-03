Leetcode - 404
  class Pair{
    TreeNode node;
    int leftOrRight;
    //left = 1 right = 0
    Pair(TreeNode node,int leftOrRight) {
        this.node = node;
        this.leftOrRight = leftOrRight;
    }
}
class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null) return 0;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root,0));
        int leftSum = 0;
        while(!q.isEmpty()) {
            Pair front = q.remove();
            if(front.node.left != null) q.add(new Pair(front.node.left,1));
            if(front.node.right != null) q.add(new Pair(front.node.right,0));
            if((front.leftOrRight == 1) && (front.node.left == null && front.node.right == null)) leftSum += front.node.val;
        }
        return leftSum;
    }
}
