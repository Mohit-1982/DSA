GFG
  class Solution {
    // Function to return sum of all nodes of a binary tree
    static int sumBT(Node root) {
        if(root == null) return 0;
        return root.data + sumBT(root.left) + sumBT(root.right);
    }
}
