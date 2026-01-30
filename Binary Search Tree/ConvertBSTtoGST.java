Leetcode - 538
  Solve this without ArrayList
  class Solution {
    public TreeNode convertBST(TreeNode root) {
        ArrayList<TreeNode> list = new ArrayList<>();
        inOrder(root,list);
        int sum = 0;
        for(int i = 0;i < list.size();i++) {
            int addInSum = list.get(i).val;
            list.get(i).val = sum + addInSum;//this line will change the data of nodes we have stored in the list;
            sum += addInSum;
        }
        return root;
    }
    public void inOrder(TreeNode root,ArrayList<TreeNode> list) {
        if(root == null) return;
        //Reverse PreOrder --> this will make sure we get the numbers reverse
        //so that we can add the suffix sum of all the number greater than the current one.
        inOrder(root.right,list);
        list.add(root);
        inOrder(root.left,list);
    }
}
