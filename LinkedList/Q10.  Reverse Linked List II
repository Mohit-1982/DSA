Leetcode - 92

class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode temp = dummy;
        for(int i = 1;i<=left-1;i++){
            temp = temp.next;
        }

        ListNode tail1 = temp;
        ListNode head1 = temp.next;
        for(int i = 1;i<=right-left+1;i++){
            temp = temp.next;
        }
        ListNode tail2 = temp;
        ListNode head2 = temp.next;
        tail1.next = null;
        tail2.next = null;
        rev(head1);
        tail1.next = tail2;
        head1.next = head2;
        return dummy.next;
    }
    public void rev(ListNode head){
        ListNode forward = head;
        ListNode current = head;
        ListNode previous = null;
        while(forward != null){
            forward = forward.next;
            current.next = previous;
            previous = current;
            current = forward;
        }
    }
}
