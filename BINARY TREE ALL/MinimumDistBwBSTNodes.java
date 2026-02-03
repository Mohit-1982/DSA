Leetcode - 783
  class Solution {
    public int minDiffInBST(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        inOrder(root,list);//this will give the values of tree in sorted order
        int j = 1;
        int minLen = Integer.MAX_VALUE;
        while(j < list.size()) {
            int diff = list.get(j) - list.get(j - 1);
            minLen = Math.min(minLen,diff);
            j++;
        }
        return minLen;
    }
    public void inOrder(TreeNode root,ArrayList<Integer> list) {
        if(root == null) return;
        inOrder(root.left,list);
        list.add(root.val);
        inOrder(root.right,list);
    }
}
