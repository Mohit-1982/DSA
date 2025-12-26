

class Solution {
    public Node reverse(Node head) {
        Node f = null;
        Node c = head;
        Node p = null;
        while(c != null){
            f = c.next;
            c.next = p;
            c.prev = f;
            p = c;
            c = f;
        }
        if(p != null){
            p.prev = null;
        }
        return p;
    }
}
