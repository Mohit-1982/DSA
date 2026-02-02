GFG

  /*
class Node
{
    int data;
    Node left;
    Node right;
    int height;
};
*/
class Solution {
    public Node insertToAVL(Node node, int data) {
        return insert(node,data);
    }
    public Node insert(Node root,int key) {
        if(root == null) {
            //we found the position to insert the key in tree
            return new Node(key);
        }
        //find the place we will place the key 
        if(root.data > key) {
            //key is going to be inserted in  left sub tree
            root.left = insert(root.left,key);
        }else if(root.data < key) {
            //key is going to be inserted in  right sub tree
            root.right = insert(root.right,key);
        }else {
            return root;//duplicates are not allowed here
        }
        //update height
        root.height = 1 + Math.max(getHeight(root.left),getHeight(root.right));
        //Balance Check
        int balance = getBalance(root);
        //Balance Check Cases :
        //Case 1 : LL
        if(balance > 1 && root.left.data > key) {
            return rightRotation(root);
        }
        //Case 2 : LR
        else if(balance > 1 && root.left.data < key) {//root.left.data < key here this line checks that the key is bigger than the root.left data so we will do right rotation after left rotation because from balance we know that the Left sub tree is imbalanced
            root.left = leftRotation(root.left);//move the middle node to the left
            return rightRotation(root);
        }
        //Case 3 : RR
        else if(balance < -1 && root.right.data < key) {
            return leftRotation(root);
        }
        //Case 4 : RL
        else if(balance < -1 && root.right.data > key) {
            root.right = rightRotation(root.right);
            return leftRotation(root);
        }
        //Case 5 : Balanced
        else {
            return root;
        }
    }
    public Node leftRotation(Node root) {
        Node child = root.right;//the node which we have to connect is on right side of root
        Node childLeft = child.left;//we have to connect the root to left of child so we have to store the left of child
        child.left = root;//now we will attach the root to left of child
        root.right = childLeft;//now the node we detached from child we are going to put it on the right of root
        //Update Height of root and child;
        root.height = 1 + Math.max(getHeight(root.left),getHeight(root.right));
        child.height = 1 + Math.max(getHeight(child.left),getHeight(child.right));
        return child;
    }
    public Node rightRotation(Node root) {
        Node child = root.left;//the node which we have to connect is on left side of root
        Node childRight = child.right;//we have to connect the root to right of child so we have to store the right of child
        child.right = root;//now we will attach the root to right of child
        root.left = childRight;//now the node we detached from child we are going to put it on the left of root
        //Update Height of root and child;
        root.height = 1 + Math.max(getHeight(root.left),getHeight(root.right));
        child.height = 1 + Math.max(getHeight(child.left),getHeight(child.right));
        return child;
    }
    public int getBalance(Node root) {
        return getHeight(root.left) - getHeight(root.right);
    }
    public int getHeight(Node root) {
        if(root == null) return 0;
        else return root.height;
    }
}
