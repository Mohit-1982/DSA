Leetcode - 445

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = rev(l1);
        l2 = rev(l2);
        ListNode a = new ListNode(-1);
        ListNode temp = a;
        int carry = 0;
        while(l1 != null || l2 != null){
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;
            int sum = x + y + carry;
            if(sum > 9) carry = 1;
            else carry = 0;
            ListNode b = new ListNode(sum%10);
            temp.next = b;
            temp = b;
           if(l1 != null) l1 = l1.next;
           if(l2 != null) l2 = l2.next;
        }
        if(carry == 1){
            ListNode b = new ListNode(1);
            temp.next = b;
        }
        a = rev(a.next);
        return a;
    }
     public ListNode rev(ListNode head){
        ListNode forward = head;
        ListNode current = head;
        ListNode previous = null;
        while(forward != null){
            forward = forward.next;
            current.next = previous;
            previous = current;
            current = forward;
        }
        return previous;
    }
}

--------------------------------------------------------------------------------------------------------------------------------

//GFG Version :

class Solution {
    public Node addTwoLists(Node head1, Node head2) {
       if(head1.data == 0){
           Node temp = head1;
           while(temp != null && temp.data == 0){
               temp = temp.next;
           }
           head1 = temp;
       }
       if(head2.data == 0){
           Node temp = head2;
           while(temp != null && temp.data == 0){
               temp = temp.next;
           }
           head2 = temp;
       }
       head1 = reverse(head1);
       head2 = reverse(head2);
       Node dummy = new Node(-1);
       Node t = dummy;
       int carry = 0;
       while(head1 != null || head2 != null){
           int x = (head1 != null) ? head1.data : 0;
           int y = (head2 != null) ? head2.data : 0;
           int sum = x + y + carry;
           if(sum > 9) carry = 1;
           else carry = 0;
           Node a = new Node(sum%10);
           t.next = a;
           t = t.next;
           if(head1 != null) head1 = head1.next;
           if(head2 != null) head2 = head2.next;
       }
       if(carry == 1){
           Node b = new Node(1);
           t.next = b;
       }
       dummy = reverse(dummy.next);
       return dummy;
    }
    Node reverse(Node head){
        Node f = null;
        Node c = head;
        Node p = null;
        while(c != null){
            f = c.next;
            c.next = p;
            p = c;
            c = f;
        }
        return p;
    }
}
