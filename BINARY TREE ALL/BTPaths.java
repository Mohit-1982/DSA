Leetcode - 257
  class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        return pathsTree(root);
    }
    public List<String> pathsTree(TreeNode root) {
        if(root == null) {
            return new ArrayList<>();
        }
        if(root.left == null && root.right == null) {
            List<String> list = new ArrayList<>();
            list.add(root.val + "");
            return list;
        }

        List<String> leftPaths = pathsTree(root.left);
        List<String> rightPaths = pathsTree(root.right);

        List<String> paths = new ArrayList<>();

        for(String ele : leftPaths) {
            paths.add(root.val + "->" + ele);
        }
        for(String ele : rightPaths) {
            paths.add(root.val + "->" + ele);
        }
        return paths;
    }
}
