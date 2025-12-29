Leetcode - 707

class MyLinkedList {
    class Node{
        int val;
        Node next;
        Node(int val){
            this.val = val;
        }
    }
    Node head;
    Node tail;
    int size;
    public MyLinkedList() {
        
    }
    
    public int get(int index) {
        if(head == null) return -1;
        Node temp = head;
        if(index<0 || index >= size) return -1;
            for(int i = 0;i<index;i++){
                temp = temp.next;
            }
            return temp.val;
    }
    
    public void addAtHead(int val) {
        Node temp = new Node(val);
        if(head == null) head = tail = temp;
        else{
            temp.next = head;
            head = temp;
        }
        size++;
    }
    
    public void addAtTail(int val) {
        Node temp = new Node(val);
        if(head == null) head = tail = temp;
        else{
            tail.next = temp;
            tail = temp;
        }
        size++;
    }
    
    public void addAtIndex(int index, int val) {
        Node temp = head;
        Node a = new Node(val);
        if(index==0) {
            addAtHead(val);
            return;
        }
        if(index == size) {
            addAtTail(val);
            return;
        }
        if(index<0 || index > size) return;
        else{
            for(int i = 0;i<index-1;i++){
                temp = temp.next;
            }
            a.next = temp.next;
            temp.next = a;
        }
        size++;
    }
    
    public void deleteAtIndex(int index) {
        Node temp = head;
        if(head == null) return;
        if(index<0 || index >= size) return;
        if(index == 0){ 
            head = head.next;
            if(head == null) tail = null;
        }
        else{
            for(int i = 0;i<index-1;i++){
                temp = temp.next;
            }
            temp.next = temp.next.next;
            if(index == size-1) tail = temp;
        }
        size--;
    }
}

