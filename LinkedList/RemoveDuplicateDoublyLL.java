

class Solution {
    Node removeDuplicates(Node head) {
        if(head == null) return null;
        Node dummy = new Node(Integer.MIN_VALUE); // i can also use head.data - 1 as list is sorted it wont be there in the list.
        Node p = dummy;
        Node c = head;
        while(c != null){
            if(p.data != c.data){
                c.prev = p;
                p.next = c;
                p = c;
            }
            c = c.next;
        }
        p.next = null;
        dummy = dummy.next;
        dummy.prev = null;
        return dummy;
    }
}
