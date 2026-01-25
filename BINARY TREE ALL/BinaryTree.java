//Traverse Tree

class Node{
    int val;
    Node left;
    Node right;
    Node(int val) {
        this.val = val;
    }
}

public class BinaryTree {
    public static void main(String[] args) {
        //Creating Nodes of Binary Tree
        Node a = new Node(3);
        Node b = new Node(4);
        Node c = new Node(2);
        Node d = new Node(-1);
        Node e = new Node(1);
        Node f = new Node(6);
        Node g = new Node(9);

        //Assigning Values to them

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.left = f;
        c.right = g;

        //Printing Value
        printTree(a);
    }
    static void printTree(Node root) {
        if(root == null) return;
        System.out.print(root.val + " ");
        printTree(root.left);
        printTree(root.right);
    }
}

