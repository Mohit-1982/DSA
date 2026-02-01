GFG
  class Solution {
    public boolean isBST(Node root) {
        //using morris traversal
        Node curr = root;
        int prev = 0;
        while(curr != null) {
            if(curr.left != null) {
                Node pred = curr.left;
                while(pred.right != null && pred.right != curr) pred = pred.right;
                if(pred.right == null) {
                    pred.right = curr;
                    curr = curr.left;
                }else {
                    pred.right = null;
                    if(curr.data <= prev) return false;
                    prev = curr.data;
                    curr = curr.right;
                }
            }else {
                if(curr.data <= prev) return false;
                prev = curr.data;
                curr = curr.right;
            }
        }
        return true;
    }
}
