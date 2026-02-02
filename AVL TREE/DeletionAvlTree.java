GFG
  /*
class Node
{
    int data, height;
    Node left, right;
    Node(int x)
    {
        data = x;
        height = 1;
        left = right = NULL;
    }
}
*/
class Sol {
    public static Node deleteNode(Node root, int key) {
        return delete(root,key);
    }
    public static Node delete(Node root,int key) {
        if(root == null) return null;
        //find the value to delete
        if(root.data > key) {
            //search on left
            root.left = delete(root.left,key);
        }else if(root.data < key) {
            //search on right;
            root.right = delete(root.right,key);
        }else {
            //we have found the Node which we have to Delete
            //Case 1 : Leaf Node
            if(root.left == null && root.right == null) {
                return null;
            }
            //Case 2 : Single Child Node
            if(root.left == null) {
                return root.right;
            }
            else if(root.right == null) {
                return root.left;
            }
            //Case 3 : Two Child Nodes
            else {
                //we have to find right child node with min value
                Node succ = root.right;
                while(succ.left != null) succ = succ.left;
                //change the values of root node and the node which we going to insert in place of root
                root.data = succ.data;
                root.right = delete(root.right,succ.data);//delete the node
            }
        }
        //Height Update
        root.height = 1 + Math.max(getHeight(root.left),getHeight(root.right));
        //Balance check
        int balance = getBalance(root);
        if(balance > 1) {
            //Left Unbalance
            //LL
            if(getBalance(root.left) >= 0) {
                return rightRotation(root);
            }
            //LR
            else {
                root.left = leftRotation(root.left);
                return rightRotation(root);
            }
        }if(balance < -1) {
            //Right Unbalance
            //RR
            if(getBalance(root.right) <= 0) {
                return leftRotation(root);
            }
            //RL
            else {
                root.right = rightRotation(root.right);
                return leftRotation(root);
            }
        }
        return root;
    }
     public static Node rightRotation(Node root) {
        Node child = root.left;
        Node childRight = child.right;
        child.right = root;
        root.left = childRight;
        root.height = 1 + Math.max(getHeight(root.left),getHeight(root.right));
        child.height = 1 + Math.max(getHeight(child.left),getHeight(child.right));
        return child;
    }
    public static Node leftRotation(Node root) {
        Node child = root.right;
        Node childLeft = child.left;
        child.left = root;
        root.right = childLeft;
        root.height = 1 + Math.max(getHeight(root.left),getHeight(root.right));
        child.height = 1 + Math.max(getHeight(child.left),getHeight(child.right));
        return child;      
    }
    public static int getHeight(Node root) {
        if(root == null) return 0;
        else return root.height;
    }
    public static int getBalance(Node root) {
        return getHeight(root.left) - getHeight(root.right);
    }
}
