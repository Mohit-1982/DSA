GFG
class GfG {
    int findDist(Node root, int a, int b) {
        Node lca = LCA(root,a,b);
        int[] arr = {0,0};
        //run our loop from that parent node ans now found the distances between them. 
        dfs(lca,a,b,0,arr);
        return arr[0] + arr[1];
    }
    void dfs(Node root,int a,int b,int level,int[] arr) {
        if(root == null) return;
        if(root.data == a) arr[0] = level;
        if(root.data == b) arr[1] = level;
        dfs(root.left,a,b,level + 1,arr);
        dfs(root.right,a,b,level + 1,arr);
        return;
    }
    Node LCA(Node root,int a,int b) {
        if(root == null) return null;
        if(root.data == a || root.data == b) return root;
        Node left = LCA(root.left,a,b);
        Node right = LCA(root.right,a,b);
        if(left != null && right != null) {
            return root;
        }
        return (left == null) ? right : left;
    }
}
