GFG
  class Solution {
    public static int findMax(Node root) {
        if(root == null) {
            return Integer.MIN_VALUE;
        }
        
        int left = findMax(root.left);
        int right = findMax(root.right);
        
        int valToRet = Math.max(root.data,Math.max(left,right));
        
        return valToRet;
    }

    public static int findMin(Node root) {
        if(root == null) {
            return Integer.MAX_VALUE;
        }
        
        int left = findMin(root.left);
        int right = findMin(root.right);
        
        int valToRet = Math.min(root.data,Math.min(left,right));
        
        return valToRet;
    }
}
