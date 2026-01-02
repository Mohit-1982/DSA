static void levelOrder(Node root) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            Node front = q.remove();
            System.out.print(front.val + " ");
            if(front.left!=null) q.add(front.left);
            if(front.right!=null) q.add(front.right);
        }
        System.out.println();
    }
