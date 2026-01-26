GFG
  class Solution {
    int getLevel(Node node, int data) {
        int ans = level(node,data,1);
        return ans;
    }
    int level(Node root,int target,int level) {
        if(root == null) return 0;
        
        if(root.data == target) return level;
        
        int left = level(root.left,target,level + 1);
        int right = level(root.right,target,level + 1);
        
        if(left > 0) return left;
        else return right;
    }
}
