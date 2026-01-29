GFG
  class Solution {
    ArrayList<Integer> inOrder(Node root) {
        ArrayList<Integer> list = new ArrayList<>();
        Stack<Node> st = new Stack<>();
        Node curr = root;
        while(!st.isEmpty() || curr != null) {
            if(curr != null) {
                if(curr.left != null) {
                    st.push(curr);
                    curr = curr.left;
                }else {
                    list.add(curr.data);
                curr = curr.right;
                }
            }else {
                Node top = st.pop();
                list.add(top.data);
                curr = top.right;
            }
        }
        return list;
    }
}
