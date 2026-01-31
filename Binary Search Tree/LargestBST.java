GFG
class Quad {
    int max;
    int min;
    int size;
    boolean isBST;
    Quad(int max,int min,int size,boolean isBST) {
        this.max = max;
        this.min = min;
        this.size = size;
        this.isBST = isBST;
    }
}
class Solution {
    static int largestBst(Node root) {
        int[] arr = new int[1];
        Quad ans = largest(root,arr);
        return arr[0];
    }
    static Quad largest(Node root,int[] arr) {
        if(root == null) return new Quad(Integer.MIN_VALUE,Integer.MAX_VALUE,0,true);
        Quad left = largest(root.left,arr);
        Quad right = largest(root.right,arr);
        int max = Math.max(root.data,Math.max(left.max,right.max));
        int min = Math.min(root.data,Math.min(left.min,right.min));
        int size = 1 + left.size + right.size;
        boolean isBST = (root.data > left.max) && (root.data < right.min) && (left.isBST) && (right.isBST);
        if(isBST) {
            arr[0] = Math.max(size,arr[0]);
        }
        return new Quad(max,min,size,isBST);
    }
}
