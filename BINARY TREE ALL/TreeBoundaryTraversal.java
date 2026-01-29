GFG
  Wrong : Try this also
  class Solution {
    ArrayList<Integer> boundaryTraversal(Node root) {
        if(root == null) return new ArrayList<>();
        
        ArrayList<Integer> leftView = new ArrayList<>();
        ArrayList<Integer> rightView = new ArrayList<>();
        ArrayList<Integer> leafNodes = new ArrayList<>();
        
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            int currLvl = q.size();
            for(int i = 0;i < currLvl;i++) {
                Node front = q.remove();
                if(i == 0) leftView.add(front.data);
                if(i != 0 && i == currLvl - 1 && (front.left != null || front.right != null)) rightView.add(front.data);
                if(front.left == null && front.right == null) leafNodes.add(front.data);
                
                if(front.left != null) q.add(front.left);
                if(front.right != null) q.add(front.right);
            }
        }
        
        ArrayList<Integer> list = new ArrayList<>();
        Collections.reverse(rightView);
        list.addAll(leftView);
        list.addAll(leafNodes);
        list.addAll(rightView);
        return list;
    }
}

Correct : 
