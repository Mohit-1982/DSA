GFG

  class Solution {
    static int size;
    public boolean isHeap(Node tree) {
       size = nodesNo(tree);
       return iscbt(tree,1) && Max(tree);
    }
    public boolean iscbt(Node tree,int idx) {
        if(tree == null) return true;
        if(idx > size) return false;
        return iscbt(tree.left,2*idx) && iscbt(tree.right,2*idx+1);
    }
    public int nodesNo(Node tree) {
        if(tree == null) return 0;
        return 1 + nodesNo(tree.left) + nodesNo(tree.right);
    }
    public boolean Max(Node root) {
        if(root == null) return true;
        if(root.left != null) {
            if(root.left.data > root.data) return false;
        }
        if(root.right != null) {
            if(root.right.data > root.data) return false;
        }
        return Max(root.left) && Max(root.right);
    }
}
