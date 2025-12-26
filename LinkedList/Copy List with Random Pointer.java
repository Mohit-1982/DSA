Leetcode - 138

class Solution {
    public Node deepCopy(Node head){
        Node temp = head;
        Node dummy = new Node(-2);
        Node t = dummy;
        while(temp != null){
            Node a = new Node(temp.val);
            t.next = a;
            t = t.next;
            temp = temp.next;
        }
        return dummy.next;
    }
    public void connect(Node h1,Node h2){
        Node dummy = new Node(-1);
        Node t = dummy;
        Node temp = h1;
        Node temp2 = h2;
        while(temp != null && temp2 != null){
            t.next = temp;
            t = t.next;
            temp = temp.next;

            t.next = temp2;
            t = t.next;
            temp2 = temp2.next;
        }
    }
    public void random(Node h1){
        Node temp = h1;
        Node temp2 = temp.next;
        while(temp != null && temp2 != null){
           if(temp.random == null) temp2.random = null;
           else  temp2.random = temp.random.next;
           temp = temp2.next;
           if(temp2.next != null) temp2 = temp.next;
        }
    }
    public void split(Node h1){
        Node d1 = new Node(-1);
        Node d2 = new Node(-1);
        Node temp = d1;
        Node temp2 = d2;
        Node t = h1;
        while(t != null){
            temp.next = t;
            t = t.next;
            temp = temp.next;

            temp2.next = t;
            t = t.next;
            temp2 = temp2.next;
        }
        temp.next = null;
    }
    public Node copyRandomList(Node head) {
        if(head == null) return head;
        Node head1 = head;
        // step 1 : create deepcopy without random 
        Node head2 = deepCopy(head1);
        // step 2 : Alternate connections 
        connect(head1,head2);
        // step 3 : Assign random 
        random(head1);
        // step 4 : splitting list
        split(head1);
        return head2;
    }
}
