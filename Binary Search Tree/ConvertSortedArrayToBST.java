Leetcode - 108
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        int n = nums.length - 1;
        return bst(nums,0,n);
    }
    public TreeNode bst(int[] arr,int s ,int e) {
        if(s > e) return null;
        int m = s + (e - s) / 2;
        TreeNode root = new TreeNode(arr[m]);
        root.left = bst(arr,s,m - 1);
        root.right = bst(arr,m + 1,e);
        return root;
    }
}
