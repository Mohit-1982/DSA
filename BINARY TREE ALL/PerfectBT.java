GFG
  //Little bit wrong
  class Solution {
    static boolean flag;
    public boolean isPerfect(Node root) {
        flag = true;
        boolean child =  checkChildrens(root);
        int level = checkLevel(root);
        return child && flag;
    }
    public int checkLevel(Node root) {
        if(root == null) return 0;
        int left = checkLevel(root.left);
        int right = checkLevel(root.right);
        if(Math.abs(left - right) > 0) {
            flag = false;
        }
        return 1 + Math.max(left,right);
    }
    public boolean checkChildrens(Node root) {
        if(root.left == null && root.right == null) return true;
        if(root.left == null || root.right == null) return false;
        boolean left = checkChildrens(root.left);
        boolean right = checkChildrens(root.right);
        return left && right;
    }
}
