GFG
  class Pair{
    Node root;
    int level;
    Pair(Node root,int level) {
        this.root = root;
        this.level = level;
    }
}
class Solution {
    public ArrayList<Integer> topView(Node root) {
        if(root == null) return new ArrayList<>();
        
        ArrayList<Integer> list = new ArrayList<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        int level = 0;
        int minDist = Integer.MAX_VALUE;
        int maxDist = Integer.MIN_VALUE;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root,level));
        
        while(!q.isEmpty()) {
            int loopTill = q.size();
            for(int i = 0;i < loopTill;i++) {
                Pair front = q.remove();
                minDist = Math.min(minDist,front.level);
                maxDist = Math.max(maxDist,front.level);
                if((!map.containsKey(front.level))) map.put(front.level,front.root.data);
                if(front.root.left != null) q.add(new Pair(front.root.left,front.level - 1));
                if(front.root.right != null) q.add(new Pair(front.root.right,front.level + 1));
            }
        }
        
        for(int i = minDist;i <= maxDist;i++) {
            list.add(map.get(i));
        }
        return list;
    }
}
