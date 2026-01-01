class Node{
    int val;
    Node left;
    Node right;
    Node(int val){
        this.val = val;
    }
}
public class Implementation {
    public static void main(String[] args) {
        Node a = new Node(3);
        Node b = new Node(4);
        Node c = new Node(2);
        Node d = new Node(-1);
        Node e = new Node(0);
        Node f = new Node(6);
        Node g = new Node(9);

        a.left = b;  a.right = c;
        b.left = d;  b.right = e;
        c.left = f;  c.right = g;
    }
}
static int product(Node root) {
        if(root == null) return 1;
        return root.val * product(root.left) * product(root.right);
    }
    static int prodNonZero(Node root) {
        if(root == null) return 1;
        if(root.val == 0) return prodNonZero(root.left) * prodNonZero(root.right);
        else return root.val * prodNonZero(root.left) * prodNonZero(root.right);
    }
