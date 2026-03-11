Leetcode - 671
Brute : 
class Solution {
    public int findSecondMinimumValue(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        helper(list, root);
        long min = Long.MAX_VALUE;
        long secMin = Long.MAX_VALUE;
        for(int i = 0; i < list.size(); i++) {
            if(list.get(i) < min) {
                secMin = min;
                min = list.get(i);
            }else if(list.get(i) > min && list.get(i) < secMin) {
                secMin = list.get(i);
            } 
        }
        if(secMin == Long.MAX_VALUE) return -1;
        return (int) secMin;
    }
    public void helper(ArrayList<Integer> list, TreeNode root) {
        if(root == null) return;
        list.add(root.val);
        helper(list, root.left);
        helper(list, root.right);
    }
}
Optimal : 
class Solution {
    public int findSecondMinimumValue(TreeNode root) {
        long[] arr = new long[2];
        arr[0] = Long.MAX_VALUE;
        arr[1] = Long.MAX_VALUE;
        helper(arr, root);
        return (arr[1] == Long.MAX_VALUE) ? -1 : (int) arr[1];
    }
    public void helper(long[] arr, TreeNode root) {
        if(root == null) return;
        if(root.val < arr[0]) {
            arr[1] = arr[0];
            arr[0] = root.val;
        }else if(root.val > arr[0] && root.val < arr[1]) {
            arr[1] = root.val;
        }
        helper(arr, root.left);
        helper(arr, root.right);
    }
}
