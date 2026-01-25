static int levelofBT(Node root) {
        if(root == null) return 0;

        int left = levelofBT(root.left);
        int right = levelofBT(root.right);

        return 1 + Math.max(left,right);
    }
