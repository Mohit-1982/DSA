Leetcode - 430

class Solution {
    public Node flatten(Node head) {
        if(head == null) return head;
        Node c = head;
        while(c != null){
            if(c.child == null) c = c.next;
            else{
                Node fwd = c.next;
                Node t = flatten(c.child);
                c.child = null;
                c.next = t;
                t.prev = c;
                Node temp = t;
                while(temp.next != null){
                    temp = temp.next;
                }
                temp.next = fwd;
                if(fwd != null) fwd.prev = temp;
                c = fwd;
            }
        }
        return head;
    }
}
