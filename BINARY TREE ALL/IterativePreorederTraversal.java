GFG
  class Solution {
    ArrayList<Integer> preOrder(Node root) {
        if(root == null) return new ArrayList<>();
        Stack<Node> st = new Stack<>();
        ArrayList<Integer> list = new ArrayList<>();
        st.push(root);
        while(!st.isEmpty()) {
            Node top = st.pop();
            list.add(top.data);
            if(top.right != null) st.push(top.right);
            if(top.left != null) st.push(top.left);
        }
        return list;
    }
}
