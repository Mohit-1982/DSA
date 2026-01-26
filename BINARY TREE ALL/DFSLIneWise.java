//DFS LINE WISE 
static void dfsLineWise(Node root,int lvl,int kthLvl) {
        if(root == null) return;
        if(lvl == kthLvl) System.out.print(root.val + " ");
        dfsLineWise(root.left,lvl + 1,kthLvl);
        dfsLineWise(root.right,lvl + 1,kthLvl);
    }
