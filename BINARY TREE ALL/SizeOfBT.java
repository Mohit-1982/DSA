GFG
class Solution {
    public static int getSize(Node node) {
        return countNodes(node);
    }
    public static int countNodes(Node node) {
        if(node == null) return 0;
        int left = countNodes(node.left);
        int right = countNodes(node.right);
        return 1 + left + right; //counting itself and adding its right and left
    }
}
