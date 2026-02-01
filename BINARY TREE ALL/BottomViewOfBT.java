GFG
  class Pair{
    Node node;
    int level;
    Pair(Node node,int level) {
        this.node = node;
        this.level = level;
    }
}
class Solution {
    public ArrayList<Integer> bottomView(Node root) {
        ArrayList<Integer> list = new ArrayList<>();
        HashMap<Integer,Node> map = new HashMap<>();
        int level = 0;
        int minDist = Integer.MAX_VALUE;
        int maxDist = Integer.MIN_VALUE;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root,level));
        while(!q.isEmpty()) {
            Pair front = q.remove();
            map.put(front.level,front.node);
            minDist = Math.min(minDist,front.level);
            maxDist = Math.max(maxDist,front.level);
            if(front.node.left != null) {
                q.add(new Pair(front.node.left,front.level - 1));
            }
            if(front.node.right != null) {
                q.add(new Pair(front.node.right,front.level + 1));
            }
        }
        for(int i = minDist;i <= maxDist;i++) {
            list.add(map.get(i).data);
        }
        return list;
    }
}
