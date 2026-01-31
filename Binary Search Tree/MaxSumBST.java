Leetcode - 1373
  class Quad {
    int max;
    int min;
    int sum;
    boolean isBST;
    Quad(int max,int min,int sum,boolean isBST) {
        this.max = max;
        this.min = min;
        this.sum = sum;
        this.isBST = isBST;
    }
}
class Solution {
    public int maxSumBST(TreeNode root) {
        int[] arr = new int[1];
        Quad ans = largest(root,arr);
        return arr[0];
    }
    public Quad largest(TreeNode root,int[] arr) {
        if(root == null) return new Quad(Integer.MIN_VALUE,Integer.MAX_VALUE,0,true);
        Quad left = largest(root.left,arr);
        Quad right = largest(root.right,arr);
        int max = Math.max(root.val,Math.max(left.max,right.max));
        int min = Math.min(root.val,Math.min(left.min,right.min));
        int sum = root.val + left.sum + right.sum;
        boolean isBST = (root.val > left.max) && (root.val < right.min) && (left.isBST) && (right.isBST);
        if(isBST) {
            arr[0] = Math.max(sum,arr[0]);
        }
        return new Quad(max,min,sum,isBST);
    }
}
