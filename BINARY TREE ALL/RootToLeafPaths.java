GFG
  class Solution {
    public static ArrayList<ArrayList<Integer>> Paths(Node root) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> rist = new ArrayList<>();
        rootToLeaf(root,ans,rist);
        return ans;
    }
    public static void rootToLeaf(Node root,ArrayList<ArrayList<Integer>> ans,ArrayList<Integer> rist) {
        if(root == null) return;
        if(root.left == null && root.right == null) {
            rist.add(root.data);
            ans.add(new ArrayList<>(rist));//weh have to store the copy of 
            //arraylist if we dont add new one then all list will become same and
            //due to backtrack we will get blank answer as 
            //rist is storing refernces.
            rist.remove(rist.size() - 1); //backTRack
            return;
        }
        rist.add(root.data);
        rootToLeaf(root.left,ans,rist);
        rootToLeaf(root.right,ans,rist);
        rist.remove(rist.size() - 1); //backTRack
    }
}
