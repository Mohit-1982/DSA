GFG
  //DFS
  class Solution {
    public ArrayList<Integer> leftView(Node root) {
        //Using dfs
        if(root == null) return new ArrayList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        dfs(root,ans,0);
        return ans;
    }
    public void dfs(Node root,ArrayList<Integer> ans,int level) {
        if(root == null) return;
        if(ans.size() <= level) {
            ans.add(root.data);
        }
        dfs(root.left,ans,level + 1);
        dfs(root.right,ans,level + 1);
    }
}

//BFS
class Solution {
    public ArrayList<Integer> leftView(Node root) {
        //Using bfs
        if(root == null) return new ArrayList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            int currLvl = q.size();
            for(int i = 0;i < currLvl;i++) {
                Node front = q.remove();
                if(i == 0) ans.add(front.data);
                if(front.left != null) q.add(front.left);
                if(front.right != null) q.add(front.right);
            }
        }
        return ans;
    }
}
