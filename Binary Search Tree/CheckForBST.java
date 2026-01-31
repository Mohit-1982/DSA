GFG
  class Triplet {
    int max;
    int min;
    boolean isBST;
    Triplet(int max,int min,boolean isBST) {
        this.max = max;
        this.min = min;
        this.isBST = isBST;
    }
}
class Solution {
    public boolean isBST(Node root) {
        //solve this using triplet class and morris traversal
        Triplet ans = bst(root);
        return ans.isBST;
    }
    public Triplet bst(Node root) {
        if(root == null) return new Triplet(Integer.MIN_VALUE,Integer.MAX_VALUE,true);
        Triplet left = bst(root.left);
        Triplet right = bst(root.right);
        int max = Math.max(root.data,Math.max(left.max,right.max));
        int min = Math.min(root.data,Math.min(left.min,right.min));
        boolean isBst = (root.data > left.max) && (root.data < right.min) && (left.isBST) && (right.isBST);
        return new Triplet(max,min,isBst);
    }
}

