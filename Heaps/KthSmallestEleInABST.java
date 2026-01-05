Leetcode - 230

class Solution {
    public int kthSmallest(TreeNode root, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        helper(pq,root);
        for(int i = 0;i<k-1;i++) {
            pq.remove();
        }
        return pq.peek();
    }
    public void helper(PriorityQueue<Integer> pq,TreeNode root) {
        if(root == null) return;
        pq.add(root.val);
        helper(pq,root.left);
        helper(pq,root.right);
    }
}
