GFG
  class Solution {
    public int minValue(Node root) {
        return min(root);
    }
    public int min(Node root) {
        if(root.left == null) return root.data;
        return min(root.left);
    }
}
