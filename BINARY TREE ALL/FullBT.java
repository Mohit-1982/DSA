GFG
  class GfG {
    boolean isFullTree(Node node) {
        if(node == null) return true;
        if(node.left == null && node.right == null) return true;
        if(node.left == null || node.right == null) return false;
        boolean left = isFullTree(node.left);
        boolean right = isFullTree(node.right);
        return left && right;
    }
}
