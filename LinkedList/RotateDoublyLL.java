

class Solution {
    public int length(Node head){
        Node temp = head;
        int size = 0;
        while(temp != null){
            temp = temp.next;
            size++;
        }
        return size;
    }
    public Node rotateDLL(Node head, int p) {
        Node temp = head;
        int len = length(head);
        p = p%len;
        if(p == 0) return head;
        for(int i = 0;i<p-1 && temp != null;i++){
            temp = temp.next;
        }
        if(temp == null || temp.next == null) return head;
        Node a = temp.next;
        a.prev = null;
        temp.next = null;
        temp = a;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = head;
        head.prev = temp;
        return a;
    }
}
