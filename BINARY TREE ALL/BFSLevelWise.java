//Using A Pair Class

//Good code
static void bfsLevelWise(Node root) {
        Queue<Pair> q = new LinkedList<>();
        int currLvl = 0;
        int level = 0;
        q.add(new Pair(root,level));
        while(!q.isEmpty()) {
            Pair front = q.remove();
            if(front.level != currLvl) {
                currLvl = front.level;
                System.out.println();
            }
            System.out.print(front.node.val + " ");
            if(front.node.left != null) q.add(new Pair(front.node.left,front.level + 1));
            if(front.node.right != null) q.add(new Pair(front.node.right,front.level + 1));
        }
    }

//Little bit complicated code 
static void bfsLevelWise(Node root) {
        Queue<Pair> q = new LinkedList<>();
        int currLvl = 0;
        int level = 0;
        q.add(new Pair(root,level));
        while(!q.isEmpty()) {
            Pair front = q.remove();
            if(front.level == currLvl) {
                System.out.print(front.node.val + " ");
                if(front.node.left != null) q.add(new Pair(front.node.left,front.level + 1));
                if(front.node.right != null) q.add(new Pair(front.node.right,front.level + 1));
            }else {
                currLvl = front.level;
                System.out.println();
                System.out.print(front.node.val + " ");
                if(front.node.left != null) q.add(new Pair(front.node.left,front.level + 1));
                if(front.node.right != null) q.add(new Pair(front.node.right,front.level + 1));
            }
        }
    }
