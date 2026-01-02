Leetcode - 102

Approach 1 :

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

            while(!q.isEmpty()) {
                int level = q.size();
                List<Integer> list = new ArrayList<>();

                for(int i = 0;i<level;i++){
                TreeNode temp = q.remove();
                if(temp.left!=null) q.add(temp.left);
                if(temp.right!=null) q.add(temp.right);
                list.add(temp.val);
            }
            ans.add(list);
        }
        return ans;
    }
}

Approach 2 : 

class Pair{
    TreeNode node;
    int level;
    Pair(TreeNode node,int level) {
        this.node = node;
        this.level = level;
    }
 }
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Queue<Pair> q = new LinkedList<>();
        helper(ans,list,root,q);
        return ans;
    }
    static void helper(List<List<Integer>> ans,List<Integer> list,TreeNode root,Queue<Pair> q) {
        if(root == null) return;
        q.add(new Pair(root,0));
        int currLvL = 0;
        list = new ArrayList<>();
        ans.add(list);
        while(q.size()>0) {
            Pair front = q.remove();
            if(front.level != currLvL) {
                list = new ArrayList<>();
                ans.add(list);
                currLvL++;
            }
            list.add(front.node.val);
            if(front.node.left!=null) q.add(new Pair(front.node.left,front.level+1));
            if(front.node.right!=null) q.add(new Pair(front.node.right,front.level+1));
        }
    }
}
