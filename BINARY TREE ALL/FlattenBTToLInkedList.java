Leetcode - 114
  Brute : 
class Solution {
    public void flatten(TreeNode root) {
        if(root == null || (root.left == null && root.right == null)) return;
        List<TreeNode> list = new ArrayList<>();
        linkedList(root,list);
        TreeNode temp = root;
        for(int i = 1;i < list.size();i++) {
            temp.left = null;
            temp.right = list.get(i);
            temp = temp.right;
        }
    }
    public void linkedList(TreeNode root,List<TreeNode> list) {
        if(root == null) return;
        list.add(root);
        linkedList(root.left,list);
        linkedList(root.right,list);
    }
}

Optimal :
class Solution {
    public void flatten(TreeNode root) {
        if(root == null) return;
        TreeNode lst = root.left;
        TreeNode rst = root.right;
        root.left = null;
        root.right = null;
        flatten(lst);
        flatten(rst);
        root.right = lst;
        TreeNode temp = root;
        while(temp.right != null) {
            temp = temp.right;
        }
        temp.right = rst;
    }
}
