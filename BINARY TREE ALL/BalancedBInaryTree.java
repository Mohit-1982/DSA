Leetcode - 110
  //BRUTE FORCE
  class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        return balanced(root);
    }
    public boolean balanced(TreeNode root) {
        if(root == null) {
            return true;
        }

        int left = level(root.left);
        int right = level(root.right);

        if(Math.abs(left - right) >= 2) {
            return false;
        }
    return balanced(root.left) && balanced(root.right);
    }
    public int level(TreeNode root) {
        if(root == null) return 0;
        return 1 + Math.max(level(root.left),level(root.right));
    }
}

//OPTIMAL : using Dynamic Programming
class Solution {
    public boolean isBalanced(TreeNode root) {
        //Using DP
        return level(root) != -1;
    }
    public int level(TreeNode root) {
        if(root == null) return 0;
        int left = level(root.left);
        if(left == -1) return -1;
        int right = level(root.right);
        if(right == -1) return -1;
        if(Math.abs(left - right) > 1) {
            return -1;
        }
        return 1 + Math.max(left,right);
    }
}
