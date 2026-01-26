static void bfs(Node root) {
        if(root == null) return;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            Node current = q.remove(); //We can use poll here as well
            System.out.print(current.val + " ");
            if(current.left != null) q.add(current.left);
            if(current.right != null) q.add(current.right);
        }
    }
