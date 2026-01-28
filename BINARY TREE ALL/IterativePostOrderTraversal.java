GFG
  class Tree {
    ArrayList<Integer> postOrder(Node node) {
        Stack<Node> st = new Stack<>();
        ArrayList<Integer> list = new ArrayList<>();
        st.push(node);
        while(st.size() > 0) {
            Node root = st.pop();
            list.add(root.data);
            if(root.left != null) st.push(root.left);
            if(root.right != null) st.push(root.right);
        }
        Collections.reverse(list);
        return list;
    }
}
