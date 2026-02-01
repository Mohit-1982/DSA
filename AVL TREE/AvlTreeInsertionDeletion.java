package AVLTree;

import java.util.LinkedList;

class newNode{
    int data;
    newNode left;
    newNode right;
    int height;
    newNode(int data,newNode left,newNode right,int height) {
        this.data = data;
        this.left = left;
        this.right = right;
        this.height = height;
    }
}
public class AvlTree {
    public static void main(String[] args) {
        newNode root = null;
        root = insert(root,10);
        root = insert(root,20);
        root = insert(root,30);
        root = insert(root,2);
        root = insert(root,90);
        root = insert(root,23);
        root = insert(root,67);
        root = insert(root,12);

        preOrder(root);
        System.out.println();
        inOrder(root);
    }
    static newNode insert(newNode root,int key) {
        if(root == null) return new newNode(key,null,null,1);
        if(root.data > key) {
            root.left = insert(root.left, key);
        }else if(root.data < key) {
            root.right = insert(root.right,key);
        }else {
            return root;//duplicates are not allowed
        }
        //update height
        root.height = 1 + Math.max(getHeight(root.left),getHeight(root.right));
        //balancing check
        int balance = getBalance(root);
        //Unbalanced Cases :
        //Case 1 : LL
        if(balance > 1 && root.left.data > key) {
            return rightRotation(root);
        }
        //Case 2 : RR
        else if(balance < -1 && root.right.data < key) {
            return leftRotation(root);
        }
        //Case 3 : LR
        else if(balance > 1 && root.left.data < key) {
            root.left = leftRotation(root.left);
            return rightRotation(root);
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
    static int getBalance(newNode root) {
        return getHeight(root.left) - getHeight(root.right);
    }
    static int getHeight(newNode root) {
        if(root == null) return 0;
        else return root.height;
    }
    static newNode rightRotation(newNode root) {
        newNode child = root.left;
        newNode childright = child.right;

        child.right = root;
        root.left = childright;

        //update height of root and child
        root.height = 1 + Math.max(getHeight(root.left),getHeight(root.right));
        child.height = 1 + Math.max(getHeight(child.left),getHeight(child.right));

        return child;
    }
    static newNode leftRotation(newNode root) {
        newNode child = root.right;
        newNode childleft = child.left;

        child.left = root;
        root.right = childleft;
        //update height of root and child
        root.height = 1 + Math.max(getHeight(root.left),getHeight(root.right));
        child.height = 1 + Math.max(getHeight(child.left),getHeight(child.right));

        return child;
    }
    static void preOrder(newNode root) {
        if(root == null) return;
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }
    static void inOrder(newNode root) {
        if(root == null) return;
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }


    //Deletion
    static newNode deleteNode(newNode root,int key) {
        if(root == null) return null;

        if(root.data > key) {
            root.left = deleteNode(root.left,key);
        }else if(root.data < key) {
            root.right = deleteNode(root.right,key);
        }else {
            //we have found the node with value key now we have to delete this node

            //leaf node
            if(root.left == null && root.right == null) return null;
            //one child node
            if(root.left == null) return root.right;
            else if(root.right == null) return root.left;
            //two child node
            else {
                //right side smallest element
                newNode smallest = root.right;
                while(smallest.left != null) smallest = smallest.left;
                root.data = smallest.data;//changed the value of the node we have to delete with smallest in right
                root.right = deleteNode(root.right,smallest.data);//delete the node whose value we have taken

            }
        }
        //Height Update
        root.height = 1 + Math.max(getHeight(root.left),getHeight(root.right));
        //Balancing check
        int balance = getBalance(root);
        //left side
        if(balance > 1) {
            int balanceLeft = getBalance(root.left);
            if(balanceLeft >= 0) { //LL
                return rightRotation(root);
            }else { //balanceLeft < -1   LR
                root.left = leftRotation(root.left);
                return rightRotation(root);
            }
        }
        //right side
        else if(balance < -1) {
            int balanceRight = getBalance(root.right);
            if(balanceRight <= 0) {//RR
                return leftRotation(root);
            }else { //balanceRight >= 0    RL
                root.right = rightRotation(root.right);
                return leftRotation(root);
            }
        }
        else {
            return root;
        }
    }
}
