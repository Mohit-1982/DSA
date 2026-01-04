GFG

Approach 1 : 
  class Solution {
    public ArrayList<Integer> leftView(Node root) {
        ArrayList<Integer> list = new ArrayList<>();
        helper(list,root,0);
        return list;
    }
    public void helper(ArrayList<Integer> list,Node root,int level) {
        if(root == null) return;
        if(level == list.size()) list.add(root.data);
        
        helper(list,root.left,level+1);
        helper(list,root.right,level+1);
    }
}
  
  Approach 2 : 
class Solution {
    public ArrayList<Integer> leftView(Node root) {
        ArrayList<Integer> list = new ArrayList<>();
        mirror(root);
        view(root,list,0);
        return list;
    }
    public void view(Node root,ArrayList<Integer> list,int level) {
        if(root == null) return;
        if(level>=list.size()) list.add(root.data);
        else list.set(level,root.data);
        view(root.left,list,level+1);
        view(root.right,list,level+1);
    }
    public void mirror(Node root) {
        if(root == null) return;
        Node temp = root.left;
        root.left = root.right;
        root.right = temp;
        mirror(root.left);
        mirror(root.right);
    }
}
